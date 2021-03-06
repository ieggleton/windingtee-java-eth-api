package com.wipu.javaapi.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class WTIndex extends Contract {
    private static final String BINARY = "60806040527f302e322e340000000000000000000000000000000000000000000000000000006001557f7774696e6465780000000000000000000000000000000000000000000000000060085534801561005857600080fd5b5060008054600160a060020a0319163317808255604051600160a060020a039190911691907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908290a360098054906100b490600183016100ba565b50610104565b8154818355818111156100de576000838152602090206100de9181019083016100e3565b505050565b61010191905b808211156100fd57600081556001016100e9565b5090565b90565b611862806101136000396000f300608060405260043610620001015763ffffffff60e060020a6000350416630d2e677a811462000106578063154d56db1462000170578063189f6aef14620001a2578063292d64e014620001d857806354fd4d501462000202578063554d8b37146200021a578063715018a6146200024e5780637cf2dfae14620002665780638da5cb5b146200028d5780638f32d59b14620002a55780639f9bfeb814620002d1578063bb979c3d14620002f5578063ca63a55b1462000319578063cb2ef6f71462000331578063cd3382651462000349578063f2f0967b1462000364578063f2fde38b1462000388578063f88a067f14620003ac578063fb6f687514620003cf575b600080fd5b3480156200011357600080fd5b506200011e620003f3565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156200015c57818101518382015260200162000142565b505050509050019250505060405180910390f35b3480156200017d57600080fd5b50620001a060048035600160a060020a0316906024803590810191013562000457565b005b348015620001af57600080fd5b50620001c6600160a060020a0360043516620005f2565b60408051918252519081900360200190f35b348015620001e557600080fd5b50620001a0600160a060020a036004358116906024351662000604565b3480156200020f57600080fd5b50620001c66200088c565b3480156200022757600080fd5b506200023262000892565b60408051600160a060020a039092168252519081900360200190f35b3480156200025b57600080fd5b50620001a0620008a1565b3480156200027357600080fd5b5062000232600160a060020a036004351660243562000901565b3480156200029a57600080fd5b506200023262000939565b348015620002b257600080fd5b50620002bd62000948565b604080519115158252519081900360200190f35b348015620002de57600080fd5b50620001c6600160a060020a036004351662000959565b3480156200030257600080fd5b506200011e600160a060020a03600435166200096b565b3480156200032657600080fd5b50620001c6620009e3565b3480156200033e57600080fd5b50620001c6620009e9565b3480156200035657600080fd5b5062000232600435620009ef565b3480156200037157600080fd5b50620001a0600160a060020a036004351662000a18565b3480156200039557600080fd5b50620001a0600160a060020a036004351662000a50565b348015620003b957600080fd5b50620001a0600480356024810191013562000a74565b348015620003dc57600080fd5b50620001a0600160a060020a036004351662000bbc565b606060098054806020026020016040519081016040528092919081815260200182805480156200044d57602002820191906000526020600020905b8154600160a060020a031681526001909101906020018083116200042e575b5050505050905090565b6000600160a060020a03841615156200046f57600080fd5b600160a060020a0384166000908152600a602052604090205415156200049457600080fd5b336000908152600b60209081526040808320600160a060020a0388168452600c90925282205481548110620004c557fe5b600091825260209091200154600160a060020a03161415620004e657600080fd5b83905030600160a060020a031681600160a060020a0316632986c0e56040518163ffffffff1660e060020a028152600401602060405180830381600087803b1580156200053257600080fd5b505af115801562000547573d6000803e3d6000fd5b505050506040513d60208110156200055e57600080fd5b5051600160a060020a0316146200057457600080fd5b83600160a060020a03168383604051808383808284378201915050925050506000604051808303816000865af19150501515620005b057600080fd5b60408051600160a060020a038616815290517fe09d7761b6b107f86a1147fb54f3b8a8b920f81cec2bf9882e16f0f58bf2b88b9181900360200190a150505050565b600c6020526000908152604090205481565b600080600160a060020a03841615156200061d57600080fd5b600160a060020a03831615156200063357600080fd5b600160a060020a0384166000908152600a602052604090205415156200065857600080fd5b336000908152600b60209081526040808320600160a060020a0388168452600c909252822054815481106200068957fe5b600091825260209091200154600160a060020a03161415620006aa57600080fd5b83915030600160a060020a031682600160a060020a0316632986c0e56040518163ffffffff1660e060020a028152600401602060405180830381600087803b158015620006f657600080fd5b505af11580156200070b573d6000803e3d6000fd5b505050506040513d60208110156200072257600080fd5b5051600160a060020a0316146200073857600080fd5b81600160a060020a031663a3fbbaae846040518263ffffffff1660e060020a0281526004018082600160a060020a0316600160a060020a03168152602001915050600060405180830381600087803b1580156200079457600080fd5b505af1158015620007a9573d6000803e3d6000fd5b505050600160a060020a0385166000908152600c6020908152604080832054338452600b9092529091208054919350915082908110620007e557fe5b600091825260208083209091018054600160a060020a0319908116909155600160a060020a03868116808552600b80855260408087208054948c16808952600c885282892086905592875260018501815587529585902090920180549093168217909255835190815233928101929092528183015290517f04dd8111702c5243bbb71b52b4f9d4b8f0bb3c448129ab39fd472b7c8182d1319181900360600190a150505050565b60015481565b600d54600160a060020a031681565b620008ab62000948565b1515620008b757600080fd5b60008054604051600160a060020a03909116907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908390a360008054600160a060020a0319169055565b600b602052816000526040600020818154811015156200091d57fe5b600091825260209091200154600160a060020a03169150829050565b600054600160a060020a031690565b600054600160a060020a0316331490565b600a6020526000908152604090205481565b600160a060020a0381166000908152600b6020908152604091829020805483518184028101840190945280845260609392830182828015620009d757602002820191906000526020600020905b8154600160a060020a03168152600190910190602001808311620009b8575b50505050509050919050565b60095490565b60085481565b6009805482908110620009fe57fe5b600091825260209091200154600160a060020a0316905081565b62000a2262000948565b151562000a2e57600080fd5b600d8054600160a060020a031916600160a060020a0392909216919091179055565b62000a5a62000948565b151562000a6657600080fd5b62000a718162000e30565b50565b60003383833062000a8462000ea1565b600160a060020a0380861682528216604082015260606020820181815290820184905260808201858580828437820191505095505050505050604051809103906000f08015801562000ada573d6000803e3d6000fd5b5060098054600160a060020a0383166000818152600a6020818152604080842086815560018088019098557f6e1540171b6c0c960b71a7020d9f60077f6af931a8bbf590da0223dacf75c7af9096018054600160a060020a03199081168717909155338552600b83528185208054878752600c8552838720818155998101825590865283862001805490911686179055928490529454908552925481519283529382019290925280820192909252519192507f48ef5bfc00516d6bf1a7f158974c1fba6bf24e304f11694183817750fb6f0b82919081900360600190a1505050565b60008080600160a060020a038416151562000bd657600080fd5b600160a060020a0384166000908152600a6020526040902054151562000bfb57600080fd5b336000908152600b60209081526040808320600160a060020a0388168452600c9092528220548154811062000c2c57fe5b600091825260209091200154600160a060020a0316141562000c4d57600080fd5b83925030600160a060020a031683600160a060020a0316632986c0e56040518163ffffffff1660e060020a028152600401602060405180830381600087803b15801562000c9957600080fd5b505af115801562000cae573d6000803e3d6000fd5b505050506040513d602081101562000cc557600080fd5b5051600160a060020a03161462000cdb57600080fd5b82600160a060020a03166383197ef06040518163ffffffff1660e060020a028152600401600060405180830381600087803b15801562000d1a57600080fd5b505af115801562000d2f573d6000803e3d6000fd5b505050600160a060020a0385166000908152600c6020908152604080832054600a909252909120546009805492955090935091508290811062000d6e57fe5b600091825260208083209091018054600160a060020a0319169055600160a060020a0386168252600a81526040808320839055338352600b909152902080548390811062000db857fe5b600091825260208083209091018054600160a060020a0319169055600160a060020a038616808352600c8252604080842093909355825190815290810184905280820183905290517f54f58abd720fd85fca71338625f22827f2e77f00c1bc457b210203060734882e9181900360600190a150505050565b600160a060020a038116151562000e4657600080fd5b60008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a360008054600160a060020a031916600160a060020a0392909216919091179055565b6040516109848062000eb383390190560060806040527f302e322e340000000000000000000000000000000000000000000000000000006000557f686f74656c00000000000000000000000000000000000000000000000000000060075534801561005857600080fd5b50604051610984380380610984833981016040908152815160208301519183015190929190910190600160a060020a038316151561009557600080fd5b600160a060020a03811615156100aa57600080fd5b815115156100b757600080fd5b60028054600160a060020a03808616600160a060020a031992831617909255600580549284169290911691909117905581516100fa906003906020850190610139565b5060408051600580825260c08201909252906020820160a0803883395050815161012b9260069250602001906101b7565b505043600455506102599050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061017a57805160ff19168380011785556101a7565b828001600101855582156101a7579182015b828111156101a757825182559160200191906001019061018c565b506101b3929150610218565b5090565b82805482825590600052602060002090810192821561020c579160200282015b8281111561020c5782518254600160a060020a031916600160a060020a039091161782556020909201916001909101906101d7565b506101b3929150610235565b61023291905b808211156101b3576000815560010161021e565b90565b61023291905b808211156101b3578054600160a060020a031916815560010161023b565b61071c806102686000396000f3006080604052600436106100cf5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663225cadd381146100d45780632986c0e514610109578063325a19f11461013a578063481c6a75146101615780635417e8411461017657806354fd4d5014610197578063619ca250146101ac57806383197ef0146101c15780638a9b29eb146101d85780638cd2894f1461026257806396b201741461027a5780639d9b53421461029b578063a3fbbaae146102f4578063cb2ef6f714610315575b600080fd5b3480156100e057600080fd5b506100f5600160a060020a036004351661032a565b604080519115158252519081900360200190f35b34801561011557600080fd5b5061011e610396565b60408051600160a060020a039092168252519081900360200190f35b34801561014657600080fd5b5061014f6103a5565b60408051918252519081900360200190f35b34801561016d57600080fd5b5061011e6103ab565b34801561018257600080fd5b5061014f600160a060020a03600435166103ba565b3480156101a357600080fd5b5061014f610404565b3480156101b857600080fd5b5061014f61040a565b3480156101cd57600080fd5b506101d6610460565b005b3480156101e457600080fd5b506101ed610481565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561022757818101518382015260200161020f565b50505050905090810190601f1680156102545780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561026e57600080fd5b5061011e60043561050f565b34801561028657600080fd5b506100f5600160a060020a0360043516610537565b3480156102a757600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101d69436949293602493928401919081908401838280828437509497506105969650505050505050565b34801561030057600080fd5b506101d6600160a060020a03600435166105b9565b34801561032157600080fd5b5061014f6105d9565b600080610336836103ba565b905060001981141561034757600080fd5b8260068281548110151561035757fe5b6000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905550600192915050565b600554600160a060020a031681565b60045481565b600254600160a060020a031681565b600080600160a060020a03831615156103d257600080fd5b6103db83610537565b156103e557600080fd5b6103ed61040a565b90506000198114156103fe57600080fd5b92915050565b60005481565b60006005815b818110156104555760068054600091908390811061042a57fe5b600091825260209091200154600160a060020a0316141561044d5780925061045b565b600101610410565b60001992505b505090565b600554600160a060020a0316331461047757600080fd5b61047f6105df565b565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156105075780601f106104dc57610100808354040283529160200191610507565b820191906000526020600020905b8154815290600101906020018083116104ea57829003601f168201915b505050505081565b600680548290811061051d57fe5b600091825260209091200154600160a060020a0316905081565b60006005815b8181101561058a5783600160a060020a031660068281548110151561055e57fe5b600091825260209091200154600160a060020a03161415610582576001925061058f565b60010161053d565b600092505b5050919050565b600554600160a060020a031633146105ad57600080fd5b6105b6816105ed565b50565b600554600160a060020a031633146105d057600080fd5b6105b681610611565b60075481565b600254600160a060020a0316ff5b805115156105fa57600080fd5b805161060d906003906020840190610655565b5050565b600160a060020a038116151561062657600080fd5b6002805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061069657805160ff19168380011785556106c3565b828001600101855582156106c3579182015b828111156106c35782518255916020019190600101906106a8565b506106cf9291506106d3565b5090565b6106ed91905b808211156106cf57600081556001016106d9565b905600a165627a7a72305820085df3116306ac11fc59b4cf5572c6c0fe44ec9768b7d4e33c130c87f1d60e690029a165627a7a72305820cc8c63db9405d7655fa97ab1385d3682f73ba283626ee8cbc1dcf9c14d9be0d50029";

    public static final String FUNC_GETHOTELS = "getHotels";

    public static final String FUNC_CALLHOTEL = "callHotel";

    public static final String FUNC_HOTELSBYMANAGERINDEX = "hotelsByManagerIndex";

    public static final String FUNC_TRANSFERHOTEL = "transferHotel";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_LIFTOKEN = "LifToken";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_HOTELSBYMANAGER = "hotelsByManager";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_HOTELSINDEX = "hotelsIndex";

    public static final String FUNC_GETHOTELSBYMANAGER = "getHotelsByManager";

    public static final String FUNC_GETHOTELSLENGTH = "getHotelsLength";

    public static final String FUNC_CONTRACTTYPE = "contractType";

    public static final String FUNC_HOTELS = "hotels";

    public static final String FUNC_SETLIFTOKEN = "setLifToken";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_REGISTERHOTEL = "registerHotel";

    public static final String FUNC_DELETEHOTEL = "deleteHotel";

    public static final Event HOTELREGISTERED_EVENT = new Event("HotelRegistered", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event HOTELDELETED_EVENT = new Event("HotelDeleted", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event HOTELCALLED_EVENT = new Event("HotelCalled", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event HOTELTRANSFERRED_EVENT = new Event("HotelTransferred", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList());
    ;

    protected WTIndex(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected WTIndex(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<List> getHotels() {
        final Function function = new Function(FUNC_GETHOTELS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> callHotel(String hotel, byte[] data) {
        final Function function = new Function(
                FUNC_CALLHOTEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hotel), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> hotelsByManagerIndex(String param0) {
        final Function function = new Function(FUNC_HOTELSBYMANAGERINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferHotel(String hotel, String newManager) {
        final Function function = new Function(
                FUNC_TRANSFERHOTEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hotel), 
                new org.web3j.abi.datatypes.Address(newManager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> LifToken() {
        final Function function = new Function(FUNC_LIFTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> hotelsByManager(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_HOTELSBYMANAGER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isOwner() {
        final Function function = new Function(FUNC_ISOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> hotelsIndex(String param0) {
        final Function function = new Function(FUNC_HOTELSINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> getHotelsByManager(String manager) {
        final Function function = new Function(FUNC_GETHOTELSBYMANAGER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(manager)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<BigInteger> getHotelsLength() {
        final Function function = new Function(FUNC_GETHOTELSLENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> contractType() {
        final Function function = new Function(FUNC_CONTRACTTYPE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> hotels(BigInteger param0) {
        final Function function = new Function(FUNC_HOTELS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setLifToken(String _LifToken) {
        final Function function = new Function(
                FUNC_SETLIFTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_LifToken)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> registerHotel(String dataUri) {
        final Function function = new Function(
                FUNC_REGISTERHOTEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(dataUri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> deleteHotel(String hotel) {
        final Function function = new Function(
                FUNC_DELETEHOTEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hotel)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<WTIndex> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WTIndex.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<WTIndex> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WTIndex.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<HotelRegisteredEventResponse> getHotelRegisteredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(HOTELREGISTERED_EVENT, transactionReceipt);
        ArrayList<HotelRegisteredEventResponse> responses = new ArrayList<HotelRegisteredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HotelRegisteredEventResponse typedResponse = new HotelRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.managerIndex = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.allIndex = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<HotelRegisteredEventResponse> hotelRegisteredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, HotelRegisteredEventResponse>() {
            @Override
            public HotelRegisteredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(HOTELREGISTERED_EVENT, log);
                HotelRegisteredEventResponse typedResponse = new HotelRegisteredEventResponse();
                typedResponse.log = log;
                typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.managerIndex = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.allIndex = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<HotelRegisteredEventResponse> hotelRegisteredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HOTELREGISTERED_EVENT));
        return hotelRegisteredEventObservable(filter);
    }

    public List<HotelDeletedEventResponse> getHotelDeletedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(HOTELDELETED_EVENT, transactionReceipt);
        ArrayList<HotelDeletedEventResponse> responses = new ArrayList<HotelDeletedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HotelDeletedEventResponse typedResponse = new HotelDeletedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.managerIndex = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.allIndex = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<HotelDeletedEventResponse> hotelDeletedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, HotelDeletedEventResponse>() {
            @Override
            public HotelDeletedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(HOTELDELETED_EVENT, log);
                HotelDeletedEventResponse typedResponse = new HotelDeletedEventResponse();
                typedResponse.log = log;
                typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.managerIndex = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.allIndex = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<HotelDeletedEventResponse> hotelDeletedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HOTELDELETED_EVENT));
        return hotelDeletedEventObservable(filter);
    }

    public List<HotelCalledEventResponse> getHotelCalledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(HOTELCALLED_EVENT, transactionReceipt);
        ArrayList<HotelCalledEventResponse> responses = new ArrayList<HotelCalledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HotelCalledEventResponse typedResponse = new HotelCalledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<HotelCalledEventResponse> hotelCalledEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, HotelCalledEventResponse>() {
            @Override
            public HotelCalledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(HOTELCALLED_EVENT, log);
                HotelCalledEventResponse typedResponse = new HotelCalledEventResponse();
                typedResponse.log = log;
                typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<HotelCalledEventResponse> hotelCalledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HOTELCALLED_EVENT));
        return hotelCalledEventObservable(filter);
    }

    public List<HotelTransferredEventResponse> getHotelTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(HOTELTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<HotelTransferredEventResponse> responses = new ArrayList<HotelTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HotelTransferredEventResponse typedResponse = new HotelTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.previousManager = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.newManager = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<HotelTransferredEventResponse> hotelTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, HotelTransferredEventResponse>() {
            @Override
            public HotelTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(HOTELTRANSFERRED_EVENT, log);
                HotelTransferredEventResponse typedResponse = new HotelTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.hotel = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.previousManager = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.newManager = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<HotelTransferredEventResponse> hotelTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(HOTELTRANSFERRED_EVENT));
        return hotelTransferredEventObservable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public static WTIndex load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new WTIndex(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static WTIndex load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new WTIndex(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class HotelRegisteredEventResponse {
        public Log log;

        public String hotel;

        public BigInteger managerIndex;

        public BigInteger allIndex;
    }

    public static class HotelDeletedEventResponse {
        public Log log;

        public String hotel;

        public BigInteger managerIndex;

        public BigInteger allIndex;
    }

    public static class HotelCalledEventResponse {
        public Log log;

        public String hotel;
    }

    public static class HotelTransferredEventResponse {
        public Log log;

        public String hotel;

        public String previousManager;

        public String newManager;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
