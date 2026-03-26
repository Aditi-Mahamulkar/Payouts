package com.example.ServiceImp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.function.ToIntBiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.AmountRequestDTO;
import com.example.DTO.AmountResponseDTO;
import com.example.DTO.BatchHeaderResponseDTO;
import com.example.DTO.CancelResponseDTO;
import com.example.DTO.CurrencyConversionResponseDTO;
import com.example.DTO.DetailsResponseDTO;
import com.example.DTO.ErrorResponseDTO;
import com.example.DTO.FeesResponseDTO;
import com.example.DTO.FromAmountResponseDTO;
import com.example.DTO.ItemsRequestDTO;
import com.example.DTO.ItemsResponseDTO;
import com.example.DTO.LinkResponseDTO;
import com.example.DTO.PayoutItemFeesResponseDTO;
import com.example.DTO.PayoutItemResponseDTO;
import com.example.DTO.RecipientNameResponseDTO;
import com.example.DTO.SenderBatchHeaderRequestDTO;
import com.example.DTO.SenderBatchHeaderResponseDTO;
import com.example.DTO.ShowPayoutBatchResponseDTO;
import com.example.DTO.ShowPayoutItemResponseDTO;
import com.example.DTO.ToAmountResponseDTO;
import com.example.DTO.createRequestDTO;
import com.example.DTO.createResponseDTO;
import com.example.Entity.AlternateNotificationMethod;
import com.example.Entity.AmountRequest;
import com.example.Entity.AmountResponse;
import com.example.Entity.ApplicationContext;
import com.example.Entity.BatchHeader;
import com.example.Entity.CurrencyConversion;
import com.example.Entity.Details;
import com.example.Entity.Errors;
import com.example.Entity.Fees;
import com.example.Entity.FromAmount;
import com.example.Entity.ItemsRequest;
import com.example.Entity.ItemsResponse;
import com.example.Entity.Links;
import com.example.Entity.PayoutItem;
import com.example.Entity.PayoutItemfee;
import com.example.Entity.Phone;
import com.example.Entity.RecipientName;
import com.example.Entity.SenderBatchHeader;
import com.example.Entity.ToAmount;
import com.example.Repository.AlternateNotificationMethodRepository;
import com.example.Repository.AmountRepository;
import com.example.Repository.ItemsRepository;
import com.example.Repository.PhoneRepository;
import com.example.Repository.SenderBatchHeaderRepository;
import com.example.Service.PayoutService;

@Service
public class PayoutServiceImpl implements PayoutService {
    private ItemsRepository itemsRepo;
    private SenderBatchHeaderRepository senderBatchHeaderRepository;
    private AmountRepository amountRepository;
    private AlternateNotificationMethodRepository alternateNotificationMethodRepository;
    private PhoneRepository phoneRepository;
    
    
@Autowired
public PayoutServiceImpl(ItemsRepository itemsRepo, SenderBatchHeaderRepository senderBatchHeaderRepository, PhoneRepository phoneRepository, AlternateNotificationMethodRepository alternateNotificationMethodRepository, AmountRepository amountRepository) {
        this.itemsRepo = itemsRepo;
        this.senderBatchHeaderRepository = senderBatchHeaderRepository;
        this.amountRepository = amountRepository;
        this.alternateNotificationMethodRepository = alternateNotificationMethodRepository;
        this.phoneRepository = phoneRepository;
    }



    @Override
    public createResponseDTO createPayout(createRequestDTO requestDTO) {

        //Initialize DTOs
         createResponseDTO responseDTO = new createResponseDTO(null, null);
        ItemsRequestDTO itemsRequestDTO = requestDTO.getItems();
        SenderBatchHeaderRequestDTO senderBatchHeaderRequestDTO = requestDTO.getSenderBatchHeader();
            
        LinkResponseDTO linkResponseDTO = new LinkResponseDTO();
        BatchHeaderResponseDTO batchHeaderResponseDTO = new BatchHeaderResponseDTO();
        SenderBatchHeaderResponseDTO senderBatchHeaderResponseDTO = new SenderBatchHeaderResponseDTO();

        //Initialize entities
        ItemsRequest items = new ItemsRequest();
        AmountRequest amount = new AmountRequest();
        AlternateNotificationMethod alternateNotificationMethod = new AlternateNotificationMethod();
        Phone phone = new Phone();
        SenderBatchHeader senderBatchHeaderRequest = new SenderBatchHeader();
        
    
        items.setRecipientType(itemsRequestDTO.getRecipient_type());
         amount.setCurrency(itemsRequestDTO.getAmount().getCurrency());
        amount.setValue(itemsRequestDTO.getAmount().getValue());

        //items.setNote(itemsRequestDTO.getNote());
        items.setSenderItemId(itemsRequestDTO.getSender_item_id());
        items.setReceiver(itemsRequestDTO.getReceiver());

        phone.setCountryCode(itemsRequestDTO.getAlternate_notification_method().getPhone().getCountryCode());
        phone.setNationalNumber(itemsRequestDTO.getAlternate_notification_method().getPhone().getNationalNumber());
        alternateNotificationMethod.setPhone(phone);
        
        items.setNotificationLanguage(itemsRequestDTO.getNotification_language());
       
        senderBatchHeaderRequest.setSenderBatchId(senderBatchHeaderRequestDTO.getSenderBatchId());
        senderBatchHeaderRequest.setEmailSubject(senderBatchHeaderRequestDTO.getEmailSubject());
        senderBatchHeaderRequest.setEmailMessage(senderBatchHeaderRequestDTO.getEmailMessage());
        

        senderBatchHeaderRepository.save(senderBatchHeaderRequest);
        itemsRepo.save(items);
        amountRepository.save(amount);
        alternateNotificationMethodRepository.save(alternateNotificationMethod);
        phoneRepository.save(phone);
        alternateNotificationMethod.setPhone(phone);
        
       
        BatchHeader batchHeader = new BatchHeader();
            batchHeaderResponseDTO.setTimeCreated(java.time.LocalDateTime.now().toString());

        SenderBatchHeaderResponseDTO senderBatchHeaderResponse = new SenderBatchHeaderResponseDTO();

senderBatchHeaderResponse.setSenderBatchId(senderBatchHeaderRequestDTO.getSenderBatchId());
senderBatchHeaderResponse.setEmailSubject(senderBatchHeaderRequestDTO.getEmailSubject());
senderBatchHeaderResponse.setEmailMessage(senderBatchHeaderRequestDTO.getEmailMessage());
senderBatchHeaderResponse.setRecipientType(itemsRequestDTO.getRecipient_type());

batchHeaderResponseDTO.setSenderBatchHeader(senderBatchHeaderResponse);


       
        batchHeaderResponseDTO.setPayoutBatchId(senderBatchHeaderRequest.getSenderBatchId()); 
        batchHeaderResponseDTO.setBatchStatus("PENDING");

        

        linkResponseDTO.setHref("/v1/payouts/" + senderBatchHeaderRequest.getSenderBatchId()); 
        linkResponseDTO.setRel("self"); 
        linkResponseDTO.setMethod("GET");
        
       
        responseDTO.setLinks(linkResponseDTO);
        responseDTO.setBatchHeader(batchHeaderResponseDTO);
        return responseDTO;




    }
    
      @Override
    public ShowPayoutBatchResponseDTO getBatchDetails(String payout_batch_Id) {
/* 
        //Initialize DTOs
        ItemsResponseDTO itemsResponseDTO = new ItemsResponseDTO();
        LinkResponseDTO linkResponseDTO = new LinkResponseDTO();
        BatchHeaderResponseDTO batchHeaderResponseDTO = new BatchHeaderResponseDTO();

        //Initialize entities
        Items items = new Items();
        Links itemLinks = new Links();   
        PayoutItemfee payoutItemfee = new PayoutItemfee();
        PayoutItem payoutItem = new PayoutItem();
        Amount payoutItemAmount = new Amount();
        RecipientName recipientName = new RecipientName();
        CurrencyConversion currencyConversion = new CurrencyConversion();
        FromAmount fromAmount = new FromAmount();
        ToAmount toAmount = new ToAmount();
        Errors errors = new Errors();
        Details details = new Details();
        Links errorLinks = new Links();
        Links links = new Links();
        BatchHeader batchHeader = new BatchHeader();
        SenderBatchHeader senderBatchHeader = new SenderBatchHeader();
        Amount batchHeaderAmount = new Amount();
        Fees fees = new Fees();

        items.setPayoutItemId(itemsResponseDTO.getPayout_item_id());
        items.setTransactionId(itemsResponseDTO.getTransaction_id());    
        items.setActivityId(itemsResponseDTO.getActivity_id());
        items.payoutbatchid(batchHeaderResponseDTO.getPayoutBatchId());
        items.setTimeProcessed(itemsResponseDTO.getTime_processed());

        itemLinks.setHref(itemsResponseDTO.getLinks().getHref());
        itemLinks.setRel(itemsResponseDTO.getLinks().getRel());
        itemLinks.setMethod(itemsResponseDTO.getLinks().getMethod());
       
        items.transactionStatus(itemsResponseDTO.getTransaction_status());
        
        payoutItemfee.setCurrency(itemsResponseDTO.getPayout_item_fee().getCurrency());
        payoutItemfee.setValue(itemsResponseDTO.getPayout_item_fee().getValue());

        payoutItem.setNote(itemsResponseDTO.getPayout_item().getNote());
        payoutItem.setReceiver(itemsResponseDTO.getPayout_item().getReceiver());
        payoutItem.setSenderItemId(itemsResponseDTO.getPayout_item().getSenderItemId());
        

        payoutItemAmount.setCurrency(itemsResponseDTO.getPayout_item().getAmount().getCurrency());
        payoutItemAmount.setValue(itemsResponseDTO.getPayout_item().getAmount().getValue());
        payoutItem.setAmount(payoutItemAmount);

        recipientName.setPrefix(itemsResponseDTO.getPayout_item().getRecipientName().getPrefix());
        recipientName.setGiven_name(itemsResponseDTO.getPayout_item().getRecipientName().getGivenName());
        recipientName.setSurname(itemsResponseDTO.getPayout_item().getRecipientName().getSurname());
        recipientName.setMiddle_name(itemsResponseDTO.getPayout_item().getRecipientName().getMiddleName());    
        recipientName.setSuffix(itemsResponseDTO.getPayout_item().getRecipientName().getSuffix());
        recipientName.setAlternate_full_name(itemsResponseDTO.getPayout_item().getRecipientName().getAlternateFullName());
        recipientName.setFull_name(itemsResponseDTO.getPayout_item().getRecipientName().getFullName());
        payoutItem.setRecipientName(recipientName);
        
        
        payoutItem.setRecipientWallet(itemsResponseDTO.getPayout_item().getRecipientWallet());
        payoutItem.setPurpose(itemsResponseDTO.getPayout_item().getPurpose());
        
       currencyConversion.setExchangeRate(itemsResponseDTO.getCurrency_conversion().getExchangeRate());
       currencyConversion.setCurrency(itemsResponseDTO.getCurrency_conversion().getFromAmount().getCurrency());
       currencyConversion.setValue(itemsResponseDTO.getCurrency_conversion().getFromAmount().getValue());
       currencyConversion.setCurrency(itemsResponseDTO.getCurrency_conversion().getToAmount().getCurrency());
       currencyConversion.setValue(itemsResponseDTO.getCurrency_conversion().getToAmount().getValue());
        currencyConversion.setFromAmount(fromAmount);
        currencyConversion.setToAmount(toAmount);

        errors.setName(itemsResponseDTO.getName());
        */

        // =========================
        // 1. FETCH BATCH
        // =========================
        SenderBatchHeader sender = senderBatchHeaderRepository.findBySenderBatchId(payoutBatchId);

        if (sender == null) {
            throw new RuntimeException("Batch not found");
        }

        // =========================
        // 2. FETCH ITEMS
        // =========================
        List<Items> itemsList = itemsRepo.findBySenderBatchHeader(sender);

        List<ItemsResponseDTO> itemResponses = new ArrayList<>();

        for (Items item : itemsList) {

            ItemsResponseDTO itemRes = new ItemsResponseDTO();

            itemRes.setPayoutItemId(item.getId().toString());
            itemRes.setTransactionId(UUID.randomUUID().toString());
            itemRes.setActivityId(UUID.randomUUID().toString());
            itemRes.setTransactionStatus("SUCCESS");
            itemRes.setTimeProcessed(LocalDateTime.now().toString());

            // =========================
            // LINKS
            // =========================
            LinkResponseDTO link = new LinkResponseDTO();
            link.setHref("/v1/payments/payouts-item/" + item.getId());
            link.setRel("item");
            link.setMethod("GET");

            List<LinkResponseDTO> linkList = new ArrayList<>();
            linkList.add(link);
            itemRes.setLinks(linkList);

            // =========================
            // PAYOUT ITEM
            // =========================
            PayoutItemResponseDTO payoutItem = new PayoutItemResponseDTO();

            payoutItem.setNote(item.getNote());
            payoutItem.setReceiver(item.getReceiver());
            payoutItem.setSenderItemId(item.getSenderItemId());
            payoutItem.setRecipientType(item.getRecipientType());
            payoutItem.setRecipientWallet(item.getRecipientWallet());
            payoutItem.setPurpose(item.getPurpose());

            if (item.getAmount() != null) {
                AmountResponseDTO amt = new AmountResponseDTO();
                amt.setCurrency(item.getAmount().getCurrency());
                amt.setValue(item.getAmount().getValue());
                payoutItem.setAmount(amt);
            }

            itemRes.setPayoutItem(payoutItem);

            // =========================
            // FEES
            // =========================
            PayoutItemFeesResponseDTO fee = new PayoutItemFeesResponseDTO();
            fee.setCurrency("USD");
            fee.setValue("0.25");
            itemRes.setPayoutItemFee(fee);

            // =========================
            // CURRENCY CONVERSION
            // =========================
            CurrencyConversionResponseDTO conversion = new CurrencyConversionResponseDTO();

            FromAmountResponseDTO from = new FromAmountResponseDTO();
            from.setCurrency("USD");
            from.setValue("80");

            ToAmountResponseDTO to = new ToAmountResponseDTO();
            to.setCurrency("USD");
            to.setValue("70");

            conversion.setExchangeRate("USD");
            conversion.setFromAmount(from);
            conversion.setToAmount(to);

            itemRes.setCurrencyConversion(conversion);

            itemResponses.add(itemRes);
        }

            // =========================
            // SENDER HEADER
            // =========================
            SenderBatchHeaderResponseDTO senderRes = new SenderBatchHeaderResponseDTO();
            senderRes.setSenderBatchId(sender.getSenderBatchId());
            senderRes.setEmailSubject(sender.getEmailSubject());
            senderRes.setEmailMessage(sender.getEmailMessage());
            senderRes.setRecipientType(sender.getRecipientType());

            // =========================
            // BATCH HEADER
            // =========================
            BatchHeaderResponseDTO batchHeader = new BatchHeaderResponseDTO();
            batchHeader.setPayoutBatchId(sender.getSenderBatchId());
            batchHeader.setBatchStatus("SUCCESS");
            batchHeader.setTimeCreated(LocalDateTime.now().toString());
            batchHeader.setSenderBatchHeader(senderRes);

            // =========================
            // LINKS
            // =========================
            List<LinkResponseDTO> links = new ArrayList<>();

            LinkResponseDTO selfLink = new LinkResponseDTO();
            selfLink.setHref("/v1/payments/payouts/" + payoutBatchId);
            selfLink.setRel("self");
            selfLink.setMethod("GET");

            links.add(selfLink);

            // =========================
            // FINAL RESPONSE
            // =========================
            ShowPayoutBatchResponseDTO response = new ShowPayoutBatchResponseDTO();

            response.setTotalItems(itemResponses.size());
            response.setTotalPages(1);
            response.setItems(itemResponses);
            response.setLinks(links);
            response.setBatchHeader(batchHeader);

            return response;
    }

    }

        

    @Override
    public ShowPayoutItemResponseDTO getPayoutItemDetails(String payoutItemId) {
       // ItemsResponse item = itemsRepo.findByPayoutItemId(payoutItemId)
         //       .orElseGet(() -> buildDefaultItem(payoutItemId));

       
              

                

        ShowPayoutItemResponseDTO response = new ShowPayoutItemResponseDTO();
            ItemsResponse itemsResponse = (ItemsResponse) itemsRepo.findByPayoutItemId(payoutItemId);
        // Basic fields
        response.setPayoutItemId(itemsResponse.getPayoutItemId());
        response.setTransactionId(itemsResponse.getTransactionId());
        response.setActivityId(itemsResponse.getActivityId());
        response.setTransactionStatus(itemsResponse.getTransactionId());
        response.setPayoutBatchId(itemsResponse.getPayoutBatchId());
        response.setSenderBatchId(itemsResponse.getSenderBatchId());
        response.setTimeProcessed(itemsResponse.getTimeProcessed());

        // Links (self + batch)
        LinkResponseDTO selfLink = new LinkResponseDTO();
        selfLink.setHref("/v1/payouts-item/" + payoutItemId);
        selfLink.setRel("self");
        selfLink.setMethod("GET");

        LinkResponseDTO batchLink = new LinkResponseDTO();
        batchLink.setHref("/v1/payouts/" + itemsResponse.getPayoutBatchId());
        batchLink.setRel("batch");
        batchLink.setMethod("GET");

        response.setLinks(java.util.List.of(selfLink, batchLink));

        // Payout Item Object
        PayoutItemResponseDTO payoutItem = new PayoutItemResponseDTO();
        payoutItem.setRecipientType(itemsResponse.getRecipientType());
        payoutItem.setReceiver(itemsResponse.getReceiver());
        payoutItem.setNote(itemsResponse.getNote());
        payoutItem.setSenderItemId(itemsResponse.getSenderBatchId());
        if (itemsResponse.getAmount() != null) {
    AmountResponseDTO amountDto = new AmountResponseDTO(
            ((AmountResponseDTO) itemsResponse.getAmount()).getCurrency(),
            ((AmountResponseDTO) itemsResponse.getAmount()).getValue()
    );
}


        response.setPayoutItem(payoutItem);

        // Fee
        AmountResponseDTO fee = new AmountResponseDTO();
        fee.setCurrency("USD");
        fee.setValue("0.35");
        response.setPayoutItemFee(fee);

        // Errors (only set on non-successful transactions)
        if (!"SUCCESS".equalsIgnoreCase(itemsResponse.getTransactionStatus())) {
            ErrorResponseDTO errors = new ErrorResponseDTO();
            errors.setName("RECEIVER_UNREGISTERED");
            errors.setMessage("Receiver is unregistered");
            errors.setInformationLink("https://developer.paypal.com/docs/api/payments.payouts-batch#errors");
            response.setErrors(errors);
        }

        return response;
    }

    private ItemsResponse buildDefaultItem(String payoutItemId) {
        ItemsResponse item = new ItemsResponse();
        item.setPayoutItemId(payoutItemId);
        item.setTransactionId("1DG93452WK758815H");
        item.setActivityId("0E158638XS0329101");
        item.setTransactionId("RETURNED");
        item.setPayoutItemId("CQMWKDQF5GFLL");
        item.setSenderBatchId("Payouts_2018_100006");
        item.setTimeProcessed("2018-01-27T10:17:41Z");
        item.setRecipientType("EMAIL");
        item.setReceiver("receiver@example.com");
        item.setNote("Thanks for your patronage!");
        item.setSenderBatchId("14Feb_234");
        AmountResponse amount = new AmountResponse();
        amount.setCurrency("USD");
        amount.setValue("9.87");
        item.setAmount(amount);
        return item;
    }
        


     @Override
    public CancelResponseDTO cancelPayout(String payout_Item_Id) {
    
        // 1. Initialize response objects
        CancelResponseDTO cancelResponseDTO = new CancelResponseDTO();
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();

        // 2. Fetch item
       ItemsResponse item = itemsRepo.findBySenderItemId(payout_Item_Id).orElse(null);

        // 3. NOT FOUND case
        if (item == null) {
            errorResponseDTO.setName("INVALID_PAYOUT_ITEM_ID");
            errorResponseDTO.setMessage("Payout item not found: " + payout_Item_Id);
            errorResponseDTO.setInformationLink(
                    "https://developer.paypal.com/docs/api/payments.payouts-batch#errors");

            cancelResponseDTO.setPayoutItemId(payout_Item_Id);
            cancelResponseDTO.setTransactionStatus("NOT_FOUND");
            cancelResponseDTO.setErrors(errorResponseDTO);

            return cancelResponseDTO;
        }

        // 4. Validation (only UNCLAIMED can be cancelled)
        if (!"UNCLAIMED".equalsIgnoreCase(item.getTransactionStatus())) {

            errorResponseDTO.setName("PAYOUT_ITEM_NOT_CANCELLABLE");
            errorResponseDTO.setMessage(
                    "Cannot cancel payout item. Status is: " + item.getTransactionStatus());
            errorResponseDTO.setInformationLink(
                    "https://developer.paypal.com/docs/api/payments.payouts-batch#errors");

            cancelResponseDTO.setPayoutItemId(payout_Item_Id);
            cancelResponseDTO.setTransactionStatus(item.getTransactionStatus());
            cancelResponseDTO.setErrors(errorResponseDTO);

            return cancelResponseDTO;
        }

        // 5. Update status (CANCEL LOGIC)
        item.setTransactionStatus("RETURNED");
        itemsRepo.save(item);

        // 6. Build payout_item DTO
        PayoutItemResponseDTO payout_item = new PayoutItemResponseDTO();

        payout_item.setSenderItemId(item.getSenderItemId());
        payout_item.setReceiver(item.getReceiver());
        payout_item.setRecipientType(item.getRecipientType());
        payout_item.setRecipientWallet(item.getRecipientWallet());
        payout_item.setNote(item.getNote());
        payout_item.setPurpose(item.getPurpose());
        payout_item.setRecipientName(item.getRecipientName());
        payout_item.setAmount(item.getAmount());

        // 7. Fee DTO
        PayoutItemFeesResponseDTO payout_item_fee = new PayoutItemFeesResponseDTO();
        payout_item_fee.setCurrency("USD");
        payout_item_fee.setValue("0.00");

        // 8. Links
       // List<LinkResponseDTO> links = new ArrayList<>();
        Links links = new Links();

        LinkResponseDTO self = new LinkResponseDTO();
        self.setHref("/v1/payments/payouts-item/" + payout_Item_Id);
        self.setRel("self");
        self.setMethod("GET");

        LinkResponseDTO batch = new LinkResponseDTO();
        String batch_id = item.getPayoutBatchId() != null
                ? item.getPayoutBatchId()
                : payout_Item_Id;

        batch.setHref("/v1/payments/payouts/" + batch_id);
        batch.setRel("batch");
        batch.setMethod("GET");

       // links.add(self);
        //links.add(batch);

        // 9. Final Response
        cancelResponseDTO.setPayoutItemId(payout_Item_Id);
        cancelResponseDTO.setPayoutBatchId(item.getPayoutBatchId());
        cancelResponseDTO.setSenderBatchId(item.getSenderBatchId());
        cancelResponseDTO.setTransactionStatus("RETURNED");
        cancelResponseDTO.setTimeProcessed(item.getTimeProcessed());

        cancelResponseDTO.setPayoutItem(payout_item);
        cancelResponseDTO.setPayoutItemFee(payout_item_fee);
        cancelResponseDTO.setLinks(links);

        cancelResponseDTO.setErrors(null);
        cancelResponseDTO.setTransactionId(null);
        cancelResponseDTO.setActivityId(null);

        return cancelResponseDTO;
    }

}
    
    


/* 
    private void purpose(String purpose) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'purpose'");
    }



    private void notification_language(String notification_language) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notification_language'");
    }
    */
