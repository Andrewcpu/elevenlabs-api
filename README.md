# elevenlabs-api     ![Build](https://github.com/AndrewCPU/elevenlabs-api/actions/workflows/build.yml/badge.svg)
### An unofficial ElevenLabs AI Voice Generation Java API

## Getting Started
So you wanna make custom voices, huh? Well you've come to the right place.

### Installation
**Maven**

To add `elevenlabs-api` to your Maven project, use:
```xml
    <dependencies>
        ...
        <dependency>
            <groupId>net.andrewcpu.elevenlabs</groupId>
            <artifactId>elevenlabs-api</artifactId>
            <version>CURRENT_VERSION</version>
        </dependency>
        ...
    </dependencies>
```

**JAR**

Compiled JARs are available via the [Releases tab](https://github.com/AndrewCPU/elevenlabs-api/releases)

**Gradle**

*Todo*

### Setting up your API Key
To access your ElevenLabs API key, head to the [official website](https://elevenlabs.io/), you can view your `xi-api-key` using the 'Profile' tab on the website.
To set up your ElevenLabs API key, you must register it with the ElevenLabsAPI Java API like below:
```java
ElevenLabsAPI.getInstance().setAPIKey("YOUR_API_KEY_HERE");
```
*For any public repository security, you should store your API key in an environment variable, or external from your source code.*

Once you've injected your API Key, you can safely assume that you will not receive a `ElevenLabsAPINotInitiatedException`.
- - -

<!-- TOC -->
### Table of Contents
  * [Getting Started](#getting-started)
    * [Installation](#installation)
    * [Setting up your API Key](#setting-up-your-api-key)
  * [Voices](#voices)
    * [Accessing your List of Available Voices](#accessing-your-list-of-available-voices)
    * [Accessing the Default Voice Settings](#accessing-the-default-voice-settings)
    * [Getting a Voice by ID](#getting-a-voice-by-id)
    * [Deleting a voice](#deleting-a-voice)
    * [Retrieving an Updated VoiceSettings for a Voice](#retrieving-an-updated-voicesettings-for-a-voice)
    * [Updating the VoiceSettings for a Voice](#updating-the-voicesettings-for-a-voice)
    * [Editing a Voice](#editing-a-voice)
    * [Creating a Voice](#creating-a-voice)
    * [Generating Audio](#generating-audio)
  * [Samples](#samples)
    * [Accessing Voice Samples](#accessing-voice-samples)
    * [Downloading a Sample](#downloading-a-sample)
    * [Deleting a Sample](#deleting-a-sample)
  * [History](#history)
    * [Getting Generation History](#getting-generation-history)
    * [Getting a History Item](#getting-a-history-item)
    * [Downloading History](#downloading-history)
    * [Deleting a HistoryItem](#deleting-a-historyitem)
    * [Requesting the Voice for a HistoryItem](#requesting-the-voice-for-a-historyitem)
    * [Downloading a HistoryItem Audio](#downloading-a-historyitem-audio)
  * [User Management](#user-management)
    * [Getting your Subscription](#getting-your-subscription)
    * [Getting your User](#getting-your-user)
  * [Exceptions](#exceptions)
    * [*ElevenLabsAPINotInitiatedException*](#elevenlabsapinotinitiatedexception)
    * [*ElevenLabsValidationException*](#elevenlabsvalidationexception)
* [Built in Types](#built-in-types)
  * [`Voice` Related Types](#voice-related-types)
  * [`User` Related Types](#user-related-types)
* [Misc](#misc)

* [Links to ElevenLabs](#links-to-elevenlabs)
    * [**ElevenLabs Website**: https://elevenlabs.io](#elevenlabs-website--httpselevenlabsio)
    * [**ElevenLabs API Documentation**: https://api.elevenlabs.io/docs](#elevenlabs-api-documentation--httpsapielevenlabsiodocs)
<!-- TOC -->

## Links to ElevenLabs
### **ElevenLabs Website**: https://elevenlabs.io
### **ElevenLabs API Documentation**: https://api.elevenlabs.io/docs

- - -
## Voices
### Accessing your List of Available Voices
To retrieve your list of accessible Voices, you can statically utilize `Voice#getVoices()`. This will return both ElevenLab's pregenerated `Voice` models, as well as any personal `Voices` you have generated.
```java
List<Voice> voices = Voice.getVoices();
```

### Accessing the Default Voice Settings
ElevenLabs provides a default `VoiceSettings` configuration which can be accessed statically from `VoiceSettings#getDefaultVoiceSettings()` **This is a network request**.
```
VoiceSettings.getDefaultVoiceSettings();
```

### Getting a Voice by ID
Retrieving voices via their `voiceId` can be done in a few different ways.

The first retrieves a `Voice` by `voiceId` and by default includes the settings. 
```java
Voice.get(String voiceId);
```


If you don't wish to retrieve the `Voice` model with its default settings included, you can use the `Voice#get(String voiceId, boolean withSettings)` function. By specifying `false` for `withSettings`, you will receive a voice object without its default `VoiceSettings`. (They can be loaded later with `Voice#fetchSettings()`, or not at all by providing a `VoiceSettings` object when generating TTS)
```java
Voice.get(String voiceId, boolean withSettings);
```

### Deleting a voice
To delete a `Voice`, you can utilize the `Voice#delete()` function. This will delete a voice from the ElevenLabs API.
```java
Voice voice;
voice.delete();
```

### Retrieving an Updated VoiceSettings for a Voice
There may be times when the default `VoiceSettings` parameters are changed externally from the API (Via the main website or another integrated system), to retrieve and apply the most up to date `VoiceSettings` object to a `Voice`, you can use the `Voice#fetchSettings()` function. (This is a network request, and it updates the object you're acting upon)
```java
Voice voice;
voice.fetchSettings(); // requests updated settings from ElevenLabs
```

### Updating the VoiceSettings for a Voice
A `VoiceSettings` object can be modified and updated in a `Voice`.
The `Voice#updateVoiceSettings(VoiceSettings settings)` function updates the **default** voice parameters to use when generating speech. (This is a network request, and updates the object you're acting upon.)
```java
Voice voice;
voice.updateVoiceSettings(VoiceSettings settings);
```

### Editing a Voice
To edit an existing `Voice` model, you can load the `Voice` into a `VoiceBuilder` with the `VoiceBuilder#fromVoice(Voice voice)` function.
The `fromVoice(Voice voice)` function will add all the current values stored in a `Voice` object directly into the `VoiceBuilder`. (Meaning you do not have to redefine existing settings) 

You'll also see that the **Creating a Voice** section utilizes this same `VoiceBuilder` class, except it uses the `VoiceBuilder#create()` function, instead of the `VoiceBuilder#edit()` function.

When editing a voice, you **must** use `VoiceBuilder.edit()`

```java
Voice voice;
VoiceBuilder builder = VoiceBuilder.fromVoice(voice); // load the existing voice into the builder
builder.withLabel("key", "value"); // add a new label
builder.removeLabel("oldKey");
builder.withFile(new File("someAudioFile.mp3")); // add a new audio sample
voice = builder.edit(); // edit voice & return updated voice object
```

### Creating a Voice
To generate a new `Voice` model from the API, you can use the `VoiceBuilder` class to assemble the required parameters for a `Voice` model.
Some things to remember:
- All `Voice` objects must have a name. (There can only be ONE name for a `Voice`)
- At least 1 file (`Voice` Sample) must be provided with `VoiceBuilder#withFile()`
- Labels are not required, but are helpful. As many labels as you like may be applied to a `Voice`.
```java
Voice voice;
VoiceBuilder builder = new VoiceBuilder();
builder.withName("Voice name");
builder.withFile(new File("sample1.mp3"));
builder.withFile(new File("sample2.mp3"));
builder.withLabel("accent", "American");
voice = builder.create();
```

### Generating Audio
To generate an audio file with a given `Voice`, you can utilize the `Voice#generate(...)` functions.
Depending on how you access your `Voice`, (with or without settings), will decide whether you can use the implicit `voiceSettings` or if you have to specify the `VoiceSettings` object to use. Unless explicitly requesting the `Voice` without settings, every `Voice` object SHOULD contain its default `VoiceSettings`.
```java
Voice voice;
File outputFile = voice.generate(String text, VoiceSettings voiceSettings, File output);
File outputFile = voice.generate(String text, File output); // Uses default voice settings
```
- - -

## Samples
A `Sample` is used as the training data for a given `Voice` model.
### Accessing Voice Samples
To access the sample(s) for a given `Voice`, you can utilize `Voice#getSamples()`.
```java
Voice voice;
List<Sample> samples = voice.getSamples();
```
### Downloading a Sample
You can download a `Sample` via the `Sample#downloadAudio(File outputFile)` function.
The `File` parameter of `downloadAudio()` is the location of where you want to locally download the sample.
```java
Voice voice;
File file = voice.getSamples().get(0).downloadAudio(File outputFile);
```

### Deleting a Sample
Deleting a `Sample` is easy. This action makes a network request. 
```java
Sample sample;
sample.delete();
```
- - -

## History
Your ElevenLabs `History` is a collection of all of your previous TTS generations.
### Getting Generation History
To get your ElevenLabs generation `History`, you can utilize `History#get()`. (You can also retrieve your `History` from a `User` object, with `User#getHistory()`)
```java
History history = History.get();
```

### Getting a History Item
To retrieve a `HistoryItem` from your `History`, you can use `History#getHistoryItem(String itemId)`.
```java
History history;
HistoryItem item = history.getHistoryItem("itemId");
```

### Downloading History
The official API of ElevenLabs provides an endpoint for downloading multiple `HistoryItem`'s as a ZIP file. To download such items, you can pass a `String[]` containing the `HistoryItem` IDs, OR you can provide a `List<HistoryItem>` parameter. 
The second parameter is the path in which you would like to save the ZIP file.
```java
History history;
File download = history.downloadHistory(new String[]{"item-id1", "item-id2"}, new File("outputFile.zip"));
File download = history.downloadHistory(List<HistoryItem> historyItems, File outputFile);
```

### Deleting a HistoryItem
You can utilize the `HistoryItem#delete()` function to delete a `HistoryItem` from ElevenLabs.
```java
HistoryItem item;
item.delete();
```

### Requesting the Voice for a HistoryItem
By default, a `HistoryItem` contains the `voiceId` of the `Voice` used to generate it. The `getVoice()` function will send a request to the ElevenLabs API to retrieve the voice object. (See also `Voice.get()` and `Voice.getVoices()`)
```java
HistoryItem item;
Voice voice = item.getVoice();
```

### Downloading a HistoryItem Audio
A `HistoryItem` is a previous TTS generation. You can download the generation as an MP3 file by providing the `downloadAudio(File file)` function with the target location for the downloaded file. The return value is the same `File` provided as a parameter.
```java
HistoryItem item;
File file = item.downloadAudio(File outputFile);
```
- - -

## User Management

### Getting your Subscription
A `Subscription` contains all the relevant data to manage your API usage (character usage, next billing cycle, etc.) 
```java
Subscription subscription = Subscription.get();
```

### Getting your User
This endpoint will return the `User` associated with a given API key.
```java
User user = User.get();
```

- - -
## Exceptions
You'll find most actions that make network requests also will throw `IOException`, `ElevenLabsAPINotInitiatedException`, and `ElevenLabsValidationException`. 

*The only function that will make a network request **without throwing an exception is*** `HistoryItem#getVoice()`.
### *ElevenLabsAPINotInitiatedException*
This exception will be thrown if you attempt to use the library without setting an API key.
### *ElevenLabsValidationException*
This error indicates a malformed request to the ElevenLabs API. The exception should provide the location of any syntactically incorrect parameters within the request.
- - -
# Built in Types

There are a few objects and enums defined for this API.
## `Voice` Related Types
```java
Voice(String voiceId, String name, List<Sample> samples, String category, 
        Map<String, String> labels, String previewUrl, List<String> availableForTiers, 
        VoiceSettings settings)
```
```java
VoiceSettings(double stability, double similarityBoost)
```
```java
Sample(String sampleId, String fileName, String mimeType, long sizeBytes, String hash)
```
```java
History(List<HistoryItem> history)
```
```java
History.HistoryItem(String historyItemId, String voiceId, String voiceName, String text, 
        long dateUnix, int characterCountChangeFrom, int characterCountChangeTo, 
        String contentType, GenerationState state)
```

```java
public enum GenerationState {
    CREATED, 
    DELETED, 
    PROCESSING;
}
```
- - -
## `User` Related Types
```java 
User(Subscription subscription, boolean isNewUser, String xiApiKey)
```
```java
Subscription(String tier, int characterCount, int characterLimit, boolean canExtendCharacterLimit, 
        boolean allowedToExtendCharacterLimit, long nextCharacterCountResetUnix, int voiceLimit, 
        boolean canExtendVoiceLimit, boolean canUseInstantVoiceCloning, List<AvailableModel> availableModels,
		AccountStatus status, NextInvoice nextInvoice)
```
```java
AvailableModel(String modelId, String displayName, List<SupportedLanguage> supportedLanguages)
```
```java
SupportedLanguage(String isoCode, String displayName)
```
```java
NextInvoice(int amountDueCents, long nextPaymentAttemptUnix)
```
```java
public enum AccountStatus {
	TRIALING,
	ACTIVE,
	INCOMPLETE,
	INCOMPLETE_EXPIRED,
	PAST_DUE,
	CANCELED,
	UNPAID,
	FREE;
}
```

- - -

## Misc
As specified on the official ElevenLabs API Documentation, their API is experimental and all endpoints are subject to change. Depending on how they modify their API, may break this library. Should you notice any API changes / library errors, feel free to submit an issue or a PR.

If you like what you see, give it a star! :) 

- - -

#### Unit Testing
*Todo*


Thanks to ElevenLabs for making an awesome tool 🥂
