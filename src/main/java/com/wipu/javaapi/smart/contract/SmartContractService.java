package com.wipu.javaapi.smart.contract;

import com.wipu.javaapi.contracts.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class SmartContractService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmartContractService.class);

    private final String smartContractService;
    private final String smartContractPassword;
    private final String smartContractMnemoic;

    private Web3j web3j;
    private Credentials credentials;

    public SmartContractService(@Value("${smart.contract.service}") String smartContractService,
                                @Value("${smart.contract.password}") String smartContractPassword,
                                @Value("${smart.contract.mnemonic}") String smartContractMnemoic) {
        this.smartContractService = smartContractService;
        this.smartContractPassword = smartContractPassword;
        this.smartContractMnemoic = smartContractMnemoic;
    }

    @PostConstruct
    public void init() {
        web3j = Web3j.build(new HttpService(smartContractService));
        credentials = WalletUtils.loadBip39Credentials(smartContractPassword, smartContractMnemoic);
    }

    public Optional<String> getHotelDataURI(String hotelAddress) {
        Optional<String> dataUri = Optional.empty();
        Hotel hotel = Hotel.load(hotelAddress, web3j, credentials,
                DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);

        try {
            dataUri = Optional.of(hotel.dataUri().send());
        } catch (Exception ex) {
            LOGGER.warn("No data URI provided for hotel {} ", hotelAddress, ex);
        }
        return dataUri;
    }

    public List<String> getHotelPartnerDataUris(String hotelAddress) {
        List<String> partners = new ArrayList<>();
        Hotel hotel = Hotel.load(hotelAddress, web3j, credentials,
                DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);

        try {
            partners.add(hotel.partnerHotels(new BigInteger("5")).send());
        } catch (Exception ex) {
            LOGGER.warn("No data URI provided for hotel {} ", hotelAddress, ex);
        }
        return partners.stream()
                .map(this::getHotelDataURI)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }
}
