# DefaultApi

All URIs are relative to *http://metastone-dev.us-west-2.elasticbeanstalk.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changePassword**](DefaultApi.md#changePassword) | **POST** /accounts-password | 
[**createAccount**](DefaultApi.md#createAccount) | **PUT** /accounts | 
[**decksDelete**](DefaultApi.md#decksDelete) | **DELETE** /decks/{deckId} | 
[**decksGet**](DefaultApi.md#decksGet) | **GET** /decks/{deckId} | 
[**decksGetAll**](DefaultApi.md#decksGetAll) | **GET** /decks | 
[**decksPut**](DefaultApi.md#decksPut) | **PUT** /decks | 
[**decksUpdate**](DefaultApi.md#decksUpdate) | **POST** /decks/{deckId} | 
[**draftsChooseCard**](DefaultApi.md#draftsChooseCard) | **PUT** /drafts/cards | 
[**draftsChooseHero**](DefaultApi.md#draftsChooseHero) | **PUT** /drafts/hero | 
[**draftsGet**](DefaultApi.md#draftsGet) | **GET** /drafts | 
[**draftsPost**](DefaultApi.md#draftsPost) | **POST** /drafts | 
[**friendDelete**](DefaultApi.md#friendDelete) | **DELETE** /friends/{friendId} | 
[**friendPut**](DefaultApi.md#friendPut) | **PUT** /friends | 
[**getAccount**](DefaultApi.md#getAccount) | **GET** /accounts/{targetUserId} | 
[**getAccounts**](DefaultApi.md#getAccounts) | **GET** /accounts | 
[**getCards**](DefaultApi.md#getCards) | **GET** /cards | 
[**getFriendConversation**](DefaultApi.md#getFriendConversation) | **GET** /friends/{friendId}/conversation | 
[**healthCheck**](DefaultApi.md#healthCheck) | **GET** / | 
[**login**](DefaultApi.md#login) | **POST** /accounts | 
[**matchmakingConstructedDelete**](DefaultApi.md#matchmakingConstructedDelete) | **DELETE** /matchmaking/{queueId} | 
[**matchmakingConstructedGet**](DefaultApi.md#matchmakingConstructedGet) | **GET** /matchmaking/{queueId} | 
[**matchmakingConstructedQueueDelete**](DefaultApi.md#matchmakingConstructedQueueDelete) | **DELETE** /matchmaking | 
[**matchmakingConstructedQueuePut**](DefaultApi.md#matchmakingConstructedQueuePut) | **PUT** /matchmaking/{queueId} | 
[**matchmakingGet**](DefaultApi.md#matchmakingGet) | **GET** /matchmaking | 
[**sendFriendMessage**](DefaultApi.md#sendFriendMessage) | **PUT** /friends/{friendId}/conversation | 


<a name="changePassword"></a>
# **changePassword**
> ChangePasswordResponse changePassword(request)



Changes your password. Does not log you out after the password is changed. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
ChangePasswordRequest request = new ChangePasswordRequest(); // ChangePasswordRequest | 
try {
    ChangePasswordResponse result = apiInstance.changePassword(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#changePassword");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**ChangePasswordRequest**](ChangePasswordRequest.md)|  |

### Return type

[**ChangePasswordResponse**](ChangePasswordResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAccount"></a>
# **createAccount**
> CreateAccountResponse createAccount(request)



Create an account with Spellsource. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
CreateAccountRequest request = new CreateAccountRequest(); // CreateAccountRequest | 
try {
    CreateAccountResponse result = apiInstance.createAccount(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**CreateAccountRequest**](CreateAccountRequest.md)|  |

### Return type

[**CreateAccountResponse**](CreateAccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="decksDelete"></a>
# **decksDelete**
> decksDelete(deckId)



Deletes the specified deck by ID. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deckId = "deckId_example"; // String | The Deck ID to delete.
try {
    apiInstance.decksDelete(deckId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#decksDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deckId** | **String**| The Deck ID to delete. |

### Return type

null (empty response body)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="decksGet"></a>
# **decksGet**
> DecksGetResponse decksGet(deckId)



Gets a deck. Only viewable for the owner of the deck or players in the alliance. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deckId = "deckId_example"; // String | The Deck ID to get.
try {
    DecksGetResponse result = apiInstance.decksGet(deckId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#decksGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deckId** | **String**| The Deck ID to get. |

### Return type

[**DecksGetResponse**](DecksGetResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="decksGetAll"></a>
# **decksGetAll**
> DecksGetAllResponse decksGetAll()



Gets all the user&#39;s decks. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    DecksGetAllResponse result = apiInstance.decksGetAll();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#decksGetAll");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**DecksGetAllResponse**](DecksGetAllResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="decksPut"></a>
# **decksPut**
> DecksPutResponse decksPut(request)



Creates a new deck with optionally specified inventory IDs, a name and a hero class. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
DecksPutRequest request = new DecksPutRequest(); // DecksPutRequest | The deck creation request. 
try {
    DecksPutResponse result = apiInstance.decksPut(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#decksPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**DecksPutRequest**](DecksPutRequest.md)| The deck creation request.  |

### Return type

[**DecksPutResponse**](DecksPutResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="decksUpdate"></a>
# **decksUpdate**
> DecksGetResponse decksUpdate(deckId, updateCommand)



Updates the deck by adding or removing cards, changing the hero class, or renaming the deck. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String deckId = "deckId_example"; // String | The Deck ID to update.
DecksUpdateCommand updateCommand = new DecksUpdateCommand(); // DecksUpdateCommand | An update command modifying specified properties of the deck. 
try {
    DecksGetResponse result = apiInstance.decksUpdate(deckId, updateCommand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#decksUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deckId** | **String**| The Deck ID to update. |
 **updateCommand** | [**DecksUpdateCommand**](DecksUpdateCommand.md)| An update command modifying specified properties of the deck.  |

### Return type

[**DecksGetResponse**](DecksGetResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="draftsChooseCard"></a>
# **draftsChooseCard**
> DraftState draftsChooseCard(request)



Make a selection for the given draft index. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
DraftsChooseCardRequest request = new DraftsChooseCardRequest(); // DraftsChooseCardRequest | 
try {
    DraftState result = apiInstance.draftsChooseCard(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#draftsChooseCard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**DraftsChooseCardRequest**](DraftsChooseCardRequest.md)|  |

### Return type

[**DraftState**](DraftState.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="draftsChooseHero"></a>
# **draftsChooseHero**
> DraftState draftsChooseHero(request)



Choose a hero from your hero selection. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
DraftsChooseHeroRequest request = new DraftsChooseHeroRequest(); // DraftsChooseHeroRequest | 
try {
    DraftState result = apiInstance.draftsChooseHero(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#draftsChooseHero");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**DraftsChooseHeroRequest**](DraftsChooseHeroRequest.md)|  |

### Return type

[**DraftState**](DraftState.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="draftsGet"></a>
# **draftsGet**
> DraftState draftsGet()



Gets your latest state of the draft. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    DraftState result = apiInstance.draftsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#draftsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**DraftState**](DraftState.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="draftsPost"></a>
# **draftsPost**
> DraftState draftsPost(request)



Starts a draft, or make a change to your draft, like retiring early. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
DraftsPostRequest request = new DraftsPostRequest(); // DraftsPostRequest | 
try {
    DraftState result = apiInstance.draftsPost(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#draftsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**DraftsPostRequest**](DraftsPostRequest.md)|  |

### Return type

[**DraftState**](DraftState.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="friendDelete"></a>
# **friendDelete**
> UnfriendResponse friendDelete(friendId)



unfriend a user 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String friendId = "friendId_example"; // String | id of friend to unfriend.
try {
    UnfriendResponse result = apiInstance.friendDelete(friendId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#friendDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **friendId** | **String**| id of friend to unfriend. |

### Return type

[**UnfriendResponse**](UnfriendResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="friendPut"></a>
# **friendPut**
> FriendPutResponse friendPut(request)



connect with a friend 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
FriendPutRequest request = new FriendPutRequest(); // FriendPutRequest | Friend put request 
try {
    FriendPutResponse result = apiInstance.friendPut(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#friendPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**FriendPutRequest**](FriendPutRequest.md)| Friend put request  |

### Return type

[**FriendPutResponse**](FriendPutResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAccount"></a>
# **getAccount**
> GetAccountsResponse getAccount(targetUserId)



Get a specific account. Contains more information if the userId matches the requesting user. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String targetUserId = "targetUserId_example"; // String | 
try {
    GetAccountsResponse result = apiInstance.getAccount(targetUserId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **targetUserId** | **String**|  |

### Return type

[**GetAccountsResponse**](GetAccountsResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAccounts"></a>
# **getAccounts**
> GetAccountsResponse getAccounts(request)



Get a list of accounts including user profile information. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
GetAccountsRequest request = new GetAccountsRequest(); // GetAccountsRequest | 
try {
    GetAccountsResponse result = apiInstance.getAccounts(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getAccounts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**GetAccountsRequest**](GetAccountsRequest.md)|  |

### Return type

[**GetAccountsResponse**](GetAccountsResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCards"></a>
# **getCards**
> GetCardsResponse getCards(ifNoneMatch)



Gets a complete catalogue of all the cards available in Spellsource as a list of CardRecords 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String ifNoneMatch = "ifNoneMatch_example"; // String | The value returned in the ETag header from the server when this was last called, or empty if this is the first call to this resource. 
try {
    GetCardsResponse result = apiInstance.getCards(ifNoneMatch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getCards");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ifNoneMatch** | **String**| The value returned in the ETag header from the server when this was last called, or empty if this is the first call to this resource.  | [optional]

### Return type

[**GetCardsResponse**](GetCardsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFriendConversation"></a>
# **getFriendConversation**
> GetConversationResponse getFriendConversation(friendId)



get conversation with friend 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String friendId = "friendId_example"; // String | id of friend
try {
    GetConversationResponse result = apiInstance.getFriendConversation(friendId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getFriendConversation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **friendId** | **String**| id of friend |

### Return type

[**GetConversationResponse**](GetConversationResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="healthCheck"></a>
# **healthCheck**
> healthCheck()



Returns an empty body if the server is available. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    apiInstance.healthCheck();
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#healthCheck");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="login"></a>
# **login**
> LoginResponse login(request)



Login with a username and password, receiving an authentication token to use for future sessions. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
LoginRequest request = new LoginRequest(); // LoginRequest | 
try {
    LoginResponse result = apiInstance.login(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#login");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**LoginRequest**](LoginRequest.md)|  |

### Return type

[**LoginResponse**](LoginResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="matchmakingConstructedDelete"></a>
# **matchmakingConstructedDelete**
> MatchConcedeResponse matchmakingConstructedDelete(queueId)



Concedes the player&#39;s current game in this queue, or cancels their place in it. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String queueId = "queueId_example"; // String | The ID of the queue to enter.
try {
    MatchConcedeResponse result = apiInstance.matchmakingConstructedDelete(queueId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#matchmakingConstructedDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queueId** | **String**| The ID of the queue to enter. |

### Return type

[**MatchConcedeResponse**](MatchConcedeResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="matchmakingConstructedGet"></a>
# **matchmakingConstructedGet**
> GameState matchmakingConstructedGet(queueId)



Gets a renderable gamestate representing this player&#39;s current game in this queue. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String queueId = "queueId_example"; // String | The ID of the queue to enter.
try {
    GameState result = apiInstance.matchmakingConstructedGet(queueId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#matchmakingConstructedGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queueId** | **String**| The ID of the queue to enter. |

### Return type

[**GameState**](GameState.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="matchmakingConstructedQueueDelete"></a>
# **matchmakingConstructedQueueDelete**
> MatchCancelResponse matchmakingConstructedQueueDelete()



Removes your client from the matchmaking queue, regardless of which queue it is in.

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    MatchCancelResponse result = apiInstance.matchmakingConstructedQueueDelete();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#matchmakingConstructedQueueDelete");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MatchCancelResponse**](MatchCancelResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="matchmakingConstructedQueuePut"></a>
# **matchmakingConstructedQueuePut**
> MatchmakingQueuePutResponse matchmakingConstructedQueuePut(queueId, request)



Enters your client into the specified matchmaking queue. Clients have to keep their matchmaking queue entry  alive by regularly retrying when they have not yet been matched. Retry within 5 seconds. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String queueId = "queueId_example"; // String | The ID of the queue to enter.
MatchmakingQueuePutRequest request = new MatchmakingQueuePutRequest(); // MatchmakingQueuePutRequest | The matchmaking queue entry. Contains the deck. 
try {
    MatchmakingQueuePutResponse result = apiInstance.matchmakingConstructedQueuePut(queueId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#matchmakingConstructedQueuePut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queueId** | **String**| The ID of the queue to enter. |
 **request** | [**MatchmakingQueuePutRequest**](MatchmakingQueuePutRequest.md)| The matchmaking queue entry. Contains the deck.  |

### Return type

[**MatchmakingQueuePutResponse**](MatchmakingQueuePutResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="matchmakingGet"></a>
# **matchmakingGet**
> MatchmakingQueuesResponse matchmakingGet()



Gets a list of queues available for matchmaking. 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
try {
    MatchmakingQueuesResponse result = apiInstance.matchmakingGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#matchmakingGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MatchmakingQueuesResponse**](MatchmakingQueuesResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="sendFriendMessage"></a>
# **sendFriendMessage**
> SendMessageResponse sendFriendMessage(friendId, request)



send message to friend 

### Example
```java
// Import classes:
//import com.hiddenswitch.spellsource.client.ApiClient;
//import com.hiddenswitch.spellsource.client.ApiException;
//import com.hiddenswitch.spellsource.client.Configuration;
//import com.hiddenswitch.spellsource.client.auth.*;
//import com.hiddenswitch.spellsource.client.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: TokenSecurity
ApiKeyAuth TokenSecurity = (ApiKeyAuth) defaultClient.getAuthentication("TokenSecurity");
TokenSecurity.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//TokenSecurity.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String friendId = "friendId_example"; // String | id of friend
SendMessageRequest request = new SendMessageRequest(); // SendMessageRequest | Send message request
try {
    SendMessageResponse result = apiInstance.sendFriendMessage(friendId, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sendFriendMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **friendId** | **String**| id of friend |
 **request** | [**SendMessageRequest**](SendMessageRequest.md)| Send message request |

### Return type

[**SendMessageResponse**](SendMessageResponse.md)

### Authorization

[TokenSecurity](../README.md#TokenSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

