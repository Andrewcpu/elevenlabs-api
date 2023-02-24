# elevenlabs-api
An unofficial ElevenLabs AI Voice Generation Java API. I am not affiliated with ElevenLabs and am merely providing a programmatic way of accessing the public ElevenLabs Web API.

**ElevenLabs Website**: https://elevenlabs.io

**ElevenLabs API Documentation**: https://api.elevenlabs.io/docs

- - -
## Getting Started
So you wanna make custom voices, huh? Well you've come to the right place.

### Setting up your API Key
To access your ElevenLabs API key, head to the [official website](https://elevenlabs.io/), you can view your xi-api-key using the 'Profile' tab on the website.
To set up your ElevenLabs API key, you must register it with the ElevenLabsAPI Java API like below:
```java
ElevenLabsAPI.getInstance().setAPIKey("YOUR_API_KEY_HERE");
```
*For any public repository security, you should store your API key in an environment variable, or external from your source code.*

Once you've injected your API Key, you can safely assume that you will not receive a ElevenAPINotInitiatedException.
- - -

## Voices
### Accessing your List of Available Voices
To retrieve your list of accessible Voices, you can statically utilize Voice#getVoices(). This will return both ElevenLab's pregenerated Voice models, as well as any personal Voices you have generated.
```java
List<Voice> voices = Voice.getVoices();
```
- - -

### Accessing the Default Voice Settings
ElevenLabs provides a default VoiceSettings configuration which can be accessed statically from VoiceSettings#getDefaultVoiceSettings() **This is a network request**.
```
VoiceSettings.getDefaultVoiceSettings();
```
- - -

### Getting a Voice by ID
Retrieving voices via their **voiceId** can be done in a few different ways.

The first retrieves a Voice by voiceId and by default includes the settings. 
```java
Voice.get(String voiceId);
```


If you don't wish to retrieve the Voice model with it's default settings included, you can use the Voice#get(String voiceId, boolean withSettings) function. By specifying false for withSettings, you will receive a voice object without it's default VoiceSettings. (They can be loaded later with Voice#fetchSettings(), or not at all by providing a VoiceSettings object when generating TTS)
```java
Voice.get(String voiceId, boolean withSettings);
```
- - -

### Deleting a voice
To delete a voice, you can utilize the Voice#delete() function. This will delete a voice from the ElevenLabs API.
```java
Voice voice;
voice.delete();
```
- - -

### Retrieving an Updated VoiceSettings for a Voice
There may be times when the default VoiceSettings parameters are changed externally from the API (Via the main website or another integrated system), to retrieve and apply the most up to date VoiceSettings object to a voice, you can use the Voice#fetchSettings() function. (This is a network request, and it updates the object you're acting upon)
```java
Voice voice;
voice.fetchSettings(); // requests updated settings from ElevenLabs
```
- - -

### Updating the VoiceSettings for a Voice
A VoiceSettings object can be modified and updated in a voice.
The Voice#updateVoiceSettings(VoiceSettings settings) function updates the **default** voice parameters to use when generating speech. (This is a network request, and updates the object you're acting upon.)
```java
Voice voice;
voice.updateVoiceSettings(VoiceSettings settings);
```
- - -

### Editing a Voice
To edit an existing Voice model, you can load the Voice into a VoiceBuilder with the VoiceBuilder#fromVoice(Voice voice) function.
The fromVoice(Voice voice) function will add all of the current values stored in a Voice object directly into the VoiceBuilder. (Meaning you do not have to redefine existing settings) 

You'll also see that the **Creating a Voice** section utilizes this same VoiceBuilder class, except it uses the VoiceBuilder#create() function, instead of the VoiceBuilder#edit() function.

When editing a voice, you **must** use VoiceBuilder.edit()

```java
Voice voice;
VoiceBuilder builder = VoiceBuilder.fromVoice(voice); // load the existing voice into the builder
builder.withLabel("key", "value"); // add a new label
builder.removeLabel("oldKey");
builder.withFile(new File("someAudioFile.mp3")); // add a new audio sample
voice = builder.edit(); // edit voice & return updated voice object
```
- - -

### Creating a Voice
To generate a new Voice model from the API, you can use the VoiceBuilder class to assemble the required parameters for a Voice model.
Some things to remember:
- All Voices must have a name. (There can only be ONE name for a voice)
- At least 1 file (Voice Sample) must be provided with VoiceBuilder#withFile
- Labels are not required, but are helpful. As many labels as you like may be applied to a Voice.
```java
Voice voice;
VoiceBuilder builder = new VoiceBuilder();
builder.withName("Voice name");
builder.withFile(new File("sample1.mp3"));
builder.withFile(new File("sample2.mp3"));
builder.withLabel("accent", "American");
voice = builder.create();
```
- - -

### Generating Audio
To generate an Audio file with a given Voice, you can utilize the Voice#generate(...) functions.
Depending on how you access your voice, (with or without settings), will decide whether or not you can use the implicit voiceSettings or if you have to specify the VoiceSettings object to use. Unless explicitly requesting the voice without settings, every Voice object SHOULD contain it's default  VoiceSettings.
```java
Voice voice;
File outputFile = voice.generate(String text, VoiceSettings voiceSettings, File output);
File outputFile = voice.generate(String text, File output); // Uses default voice settings
```
- - -

## Samples
A Sample is used as the training data for a given Voice model.
### Accessing Voice Samples
To access the sample(s) for a given Voice, you can utilize Voice#getSamples().
```java
Voice voice;
List<Sample> samples = voice.getSamples();
```
- - -
### Downloading a Sample
You can download a Sample via the Sample#downloadAudio(File outputFile) function.
The File parameter of downloadAudio is the location of where you want to locally download the sample.
```java
Voice voice;
File file = voice.getSamples().get(0).downloadAudio(File outputFile);
```
- - -

### Deleting a Sample
```java
Sample sample;
sample.delete();
```
- - -

## History
Your ElevenLabs History is a collection of all of your previous TTS generations.
### Getting Generation History
To get your ElevenLabs generation History, you can utilize History#get(). (You can also retrieve your History from a User object, with User#getHistory())
```java
History history = History.get();
```
- - -

### Getting a History Item
To retrieve a HistoryItem from your History, you can use History#getHistoryItem(String itemId).
```java
History history;
HistoryItem item = history.getHistoryItem("itemId");
```
- - -

### Downloading History
The official API of ElevenLabs provides an endpoint for downloading multiple HistoryItem's as a ZIP file. To download such items, you can pass a String[] containing the HistoryItem IDs, OR you can provide a List of HistoryItems. 
The second parameter is the path in which you would like to save the ZIP file.
```java
History history;
File download = history.downloadHistory(new String[]{"item-id1", "item-id2"}, new File("outputFile.zip"));
File download = history.downloadHistory(List<HistoryItem> historyItems, File outputFile);
```
- - -

### Deleting a HistoryItem
You can utilize the HistoryItem#delete() function to delete a HistoryItem from ElevenLabs.
```java
HistoryItem item;
item.delete();
```
- - -

### Requesting the Voice for a HistoryItem
By default, a HistoryItem contains the voiceId of the voice used to generate it. The getVoice() function will send a request to the ElevenLabs API to retrieve the voice object. (See also Voice.get() and Voice.getVoices())
```java
HistoryItem item;
Voice voice = item.getVoice();
```
- - -

### Downloading a HistoryItem Audio
A HistoryItem is a previous TTS generation. You can download the generation as an MP3 file by providing the downloadAudio(File file) function with the target location for the downloaded file. The return value is the same File provided as a parameter.
```java
HistoryItem item;
File file = item.downloadAudio(File outputFile);
```
- - -

## User Management

### Getting your Subscription
A subscription contains all the relevant data to manage your API usage (character usage, next billing cycle, etc.) 
```java
Subscription subscription = Subscription.get();
```
- - -

### Getting your User
This endpoint will return the User associated with a given API key.
```java
User user = User.get();
```

- - -
## Exceptions
### ElevenAPINotInitiatedException
This exception will be thrown if you attempt to use the library without setting an API key.
### ElevenLabsValidationException
This error indicates a malformed request to the ElevenLabs API. The exception should provide the location of any syntactically incorrect parameters within the request.
