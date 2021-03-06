package com.wipu.javaapi.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Hotel extends Contract {
    private static final String BINARY = "60806040527f302e322e340000000000000000000000000000000000000000000000000000006000557f686f74656c00000000000000000000000000000000000000000000000000000060075534801561005857600080fd5b50604051610984380380610984833981016040908152815160208301519183015190929190910190600160a060020a038316151561009557600080fd5b600160a060020a03811615156100aa57600080fd5b815115156100b757600080fd5b60028054600160a060020a03808616600160a060020a031992831617909255600580549284169290911691909117905581516100fa906003906020850190610139565b5060408051600580825260c08201909252906020820160a0803883395050815161012b9260069250602001906101b7565b505043600455506102599050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061017a57805160ff19168380011785556101a7565b828001600101855582156101a7579182015b828111156101a757825182559160200191906001019061018c565b506101b3929150610218565b5090565b82805482825590600052602060002090810192821561020c579160200282015b8281111561020c5782518254600160a060020a031916600160a060020a039091161782556020909201916001909101906101d7565b506101b3929150610235565b61023291905b808211156101b3576000815560010161021e565b90565b61023291905b808211156101b3578054600160a060020a031916815560010161023b565b61071c806102686000396000f3006080604052600436106100cf5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663225cadd381146100d45780632986c0e514610109578063325a19f11461013a578063481c6a75146101615780635417e8411461017657806354fd4d5014610197578063619ca250146101ac57806383197ef0146101c15780638a9b29eb146101d85780638cd2894f1461026257806396b201741461027a5780639d9b53421461029b578063a3fbbaae146102f4578063cb2ef6f714610315575b600080fd5b3480156100e057600080fd5b506100f5600160a060020a036004351661032a565b604080519115158252519081900360200190f35b34801561011557600080fd5b5061011e610396565b60408051600160a060020a039092168252519081900360200190f35b34801561014657600080fd5b5061014f6103a5565b60408051918252519081900360200190f35b34801561016d57600080fd5b5061011e6103ab565b34801561018257600080fd5b5061014f600160a060020a03600435166103ba565b3480156101a357600080fd5b5061014f610404565b3480156101b857600080fd5b5061014f61040a565b3480156101cd57600080fd5b506101d6610460565b005b3480156101e457600080fd5b506101ed610481565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561022757818101518382015260200161020f565b50505050905090810190601f1680156102545780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561026e57600080fd5b5061011e60043561050f565b34801561028657600080fd5b506100f5600160a060020a0360043516610537565b3480156102a757600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101d69436949293602493928401919081908401838280828437509497506105969650505050505050565b34801561030057600080fd5b506101d6600160a060020a03600435166105b9565b34801561032157600080fd5b5061014f6105d9565b600080610336836103ba565b905060001981141561034757600080fd5b8260068281548110151561035757fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905550600192915050565b600554600160a060020a031681565b60045481565b600254600160a060020a031681565b600080600160a060020a03831615156103d257600080fd5b6103db83610537565b156103e557600080fd5b6103ed61040a565b90506000198114156103fe57600080fd5b92915050565b60005481565b60006005815b818110156104555760068054600091908390811061042a57fe5b600091825260209091200154600160a060020a0316141561044d5780925061045b565b600101610410565b60001992505b505090565b600554600160a060020a0316331461047757600080fd5b61047f6105df565b565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156105075780601f106104dc57610100808354040283529160200191610507565b820191906000526020600020905b8154815290600101906020018083116104ea57829003601f168201915b505050505081565b600680548290811061051d57fe5b600091825260209091200154600160a060020a0316905081565b60006005815b8181101561058a5783600160a060020a031660068281548110151561055e57fe5b600091825260209091200154600160a060020a03161415610582576001925061058f565b60010161053d565b600092505b5050919050565b600554600160a060020a031633146105ad57600080fd5b6105b6816105ed565b50565b600554600160a060020a031633146105d057600080fd5b6105b681610611565b60075481565b600254600160a060020a0316ff5b805115156105fa57600080fd5b805161060d906003906020840190610655565b5050565b600160a060020a038116151561062657600080fd5b6002805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061069657805160ff19168380011785556106c3565b828001600101855582156106c3579182015b828111156106c35782518255916020019190600101906106a8565b506106cf9291506106d3565b5090565b6106ed91905b808211156106cf57600081556001016106d9565b905600a165627a7a72305820085df3116306ac11fc59b4cf5572c6c0fe44ec9768b7d4e33c130c87f1d60e690029";

    public static final String FUNC_ADDPARTNERHOTEL = "addPartnerHotel";

    public static final String FUNC_INDEX = "index";

    public static final String FUNC_CREATED = "created";

    public static final String FUNC_MANAGER = "manager";

    public static final String FUNC__CHECKIFADDRESSCANBEWRITTENTOPARTNERHOTEL = "_checkIfAddressCanBeWrittenToPartnerHotel";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC__CHECKPARTNERHOTELSAREEMPTY = "_checkPartnerHotelsAreEmpty";

    public static final String FUNC_DESTROY = "destroy";

    public static final String FUNC_DATAURI = "dataUri";

    public static final String FUNC_PARTNERHOTELS = "partnerHotels";

    public static final String FUNC__CHECKPARTNERHOTELISPRESENT = "_checkPartnerHotelIsPresent";

    public static final String FUNC_EDITINFO = "editInfo";

    public static final String FUNC_CHANGEMANAGER = "changeManager";

    public static final String FUNC_CONTRACTTYPE = "contractType";

    protected Hotel(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Hotel(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> addPartnerHotel(String _partnerHotel) {
        final Function function = new Function(
                FUNC_ADDPARTNERHOTEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_partnerHotel)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> index() {
        final Function function = new Function(FUNC_INDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> created() {
        final Function function = new Function(FUNC_CREATED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> manager() {
        final Function function = new Function(FUNC_MANAGER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> _checkIfAddressCanBeWrittenToPartnerHotel(String _partnerHotel) {
        final Function function = new Function(FUNC__CHECKIFADDRESSCANBEWRITTENTOPARTNERHOTEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_partnerHotel)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> _checkPartnerHotelsAreEmpty() {
        final Function function = new Function(FUNC__CHECKPARTNERHOTELSAREEMPTY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> destroy() {
        final Function function = new Function(
                FUNC_DESTROY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> dataUri() {
        final Function function = new Function(FUNC_DATAURI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> partnerHotels(BigInteger param0) {
        final Function function = new Function(FUNC_PARTNERHOTELS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> _checkPartnerHotelIsPresent(String _partnerHotel) {
        final Function function = new Function(FUNC__CHECKPARTNERHOTELISPRESENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_partnerHotel)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> editInfo(String _dataUri) {
        final Function function = new Function(
                FUNC_EDITINFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_dataUri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeManager(String _newManager) {
        final Function function = new Function(
                FUNC_CHANGEMANAGER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newManager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> contractType() {
        final Function function = new Function(FUNC_CONTRACTTYPE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public static RemoteCall<Hotel> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _manager, String _dataUri, String _index) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_manager), 
                new org.web3j.abi.datatypes.Utf8String(_dataUri), 
                new org.web3j.abi.datatypes.Address(_index)));
        return deployRemoteCall(Hotel.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Hotel> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _manager, String _dataUri, String _index) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_manager), 
                new org.web3j.abi.datatypes.Utf8String(_dataUri), 
                new org.web3j.abi.datatypes.Address(_index)));
        return deployRemoteCall(Hotel.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Hotel load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Hotel(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Hotel load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Hotel(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
