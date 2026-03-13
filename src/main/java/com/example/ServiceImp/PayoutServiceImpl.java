package com.example.ServiceImp;

import java.util.function.ToIntBiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.example.Entity.Amount;
import com.example.Entity.ApplicationContext;
import com.example.Entity.BatchHeader;
import com.example.Entity.CurrencyConversion;
import com.example.Entity.Details;
import com.example.Entity.Errors;
import com.example.Entity.Fees;
import com.example.Entity.FromAmount;
import com.example.Entity.Items;
import com.example.Entity.Links;
import com.example.Entity.PayoutItem;
import com.example.Entity.PayoutItemfee;
import com.example.Entity.Phone;
import com.example.Entity.RecipientName;
import com.example.Entity.SenderBatchHeader;
import com.example.Entity.ToAmount;
import com.example.Repository.ItemsRepository;
import com.example.Repository.SenderBatchHeaderRepository;
import com.example.Service.PayoutService;

@Service
public class PayoutServiceImpl implements PayoutService {
    private ItemsRepository itemsRepo;
    private SenderBatchHeaderRepository senderBatchHeaderRepository;

    
@Autowired
public PayoutServiceImpl(ItemsRepository itemsRepo, SenderBatchHeaderRepository senderBatchHeaderRepository) {
        this.itemsRepo = itemsRepo;
        this.senderBatchHeaderRepository = senderBatchHeaderRepository;
    }



    @Override
    public createResponseDTO createPayout(ItemsRequestDTO requestDTO) {

        //Initialize DTOs
         createResponseDTO responseDTO = new createResponseDTO(null, null);
        ItemsRequestDTO itemsRequestDTO = new ItemsRequestDTO();
        SenderBatchHeaderRequestDTO senderBatchHeaderRequestDTO = new SenderBatchHeaderRequestDTO();    
        LinkResponseDTO linkResponseDTO = new LinkResponseDTO();
        BatchHeaderResponseDTO batchHeaderResponseDTO = new BatchHeaderResponseDTO();
        SenderBatchHeaderResponseDTO senderBatchHeaderResponseDTO = new SenderBatchHeaderResponseDTO();

        //Initialize entities
        Items items = new Items();
        Amount amount = new Amount();
        AlternateNotificationMethod alternateNotificationMethod = new AlternateNotificationMethod();
        Phone phone = new Phone();
        ApplicationContext applicationContext = new ApplicationContext();
        SenderBatchHeader senderBatchHeaderRequest = new SenderBatchHeader();
        
    
        items.setRecipientType(itemsRequestDTO.getRecipient_type());
        items.setNote(itemsRequestDTO.getNote());
        items.setReceiver(itemsRequestDTO.getReceiver());
        items.setSenderItemId(itemsRequestDTO.getSender_item_id());
        items.setRecipientWallet(itemsRequestDTO.getRecipient_wallet());

        amount.setCurrency(itemsRequestDTO.getAmount().getCurrency());
        amount.setValue(itemsRequestDTO.getAmount().getValue());

        
        phone.setCountryCode(itemsRequestDTO.getAlternate_notification_method().getPhone().getCountryCode());
        phone.setNationalNumber(itemsRequestDTO.getAlternate_notification_method().getPhone().getNationalNumber());
        phone.setExtensionNumber(itemsRequestDTO.getAlternate_notification_method().getPhone().getExtensionNumber());
        alternateNotificationMethod.setPhone(phone);
        
        items.setNotificationLanguage(itemsRequestDTO.getNotification_language());
        
        applicationContext.setSocialFeedPrivacy(itemsRequestDTO.getApplication_context().getSocialFeedPrivacy());
        applicationContext.setHollerUrl(itemsRequestDTO.getApplication_context().getHollerUrl());
        applicationContext.setLogoUrl(itemsRequestDTO.getApplication_context().getLogoUrl());
        items.setApplicationContext(applicationContext);

        items.setPurpose(itemsRequestDTO.getPurpose());

        senderBatchHeaderRequest.setSenderBatchId(senderBatchHeaderRequestDTO.getSenderBatchId());
        senderBatchHeaderRequest.setRecipientType(senderBatchHeaderRequestDTO.getRecipientType());
        senderBatchHeaderRequest.setEmailSubject(senderBatchHeaderRequestDTO.getEmailSubject());
        senderBatchHeaderRequest.setEmailMessage(senderBatchHeaderRequestDTO.getEmailMessage());
        senderBatchHeaderRequest.setNote(senderBatchHeaderRequestDTO.getNote());

        senderBatchHeaderRepository.save(senderBatchHeaderRequest);
        itemsRepo.save(items);
        
        //Response entity initialization
        Links links = new Links();
        BatchHeader batchHeader = new BatchHeader();

        SenderBatchHeaderResponseDTO senderBatchHeaderResponse = new SenderBatchHeaderResponseDTO();
    
    
        links.setHref(linkResponseDTO.getHref());
        links.setRel(linkResponseDTO.getRel());
        links.setMethod(linkResponseDTO.getMethod());

        batchHeader.setPayoutBatchId(batchHeaderResponseDTO.getPayoutBatchId());
        batchHeader.setTimeCreated(batchHeaderResponseDTO.getTimeCreated());
        batchHeader.setBatchStatus(batchHeaderResponseDTO.getBatchStatus());

        senderBatchHeaderResponse.setSenderBatchId(senderBatchHeaderResponseDTO.getSenderBatchId());
        senderBatchHeaderResponse.setEmailSubject(senderBatchHeaderResponseDTO.getEmailSubject());
        senderBatchHeaderResponse.setEmailMessage(senderBatchHeaderResponseDTO.getEmailMessage());
        senderBatchHeaderResponse.setRecipientType(senderBatchHeaderResponseDTO.getRecipientType());
        
       
        responseDTO.setLinks(linkResponseDTO);
        responseDTO.setBatchHeader(batchHeaderResponseDTO);
        return responseDTO;




    }
    
   /*  @Override
    public ShowPayoutBatchResponseDTO getBatchDetails(String payout_batch_Id) {

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
        payoutItem.setRecipientType(itemsResponseDTO.getPayout_item().getRecipientType());

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
    }
/*
    @Override
    public ShowPayoutItemResponseDTO getPayoutItemDetails(String payout_Item_Id) {
        
    }

    @Override
    public CancelResponseDTO cancelPayout(String payout_Item_Id) {
        
    }
    */


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
}
