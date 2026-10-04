# What is this?

Have you ever seen one of these?
<img width="1028" height="756" alt="image" src="https://github.com/user-attachments/assets/0843d638-b0d3-406e-b06a-68e2ab50a993" />

These are called Streamdecks, and are nifty little devices that allow you to trigger various actions on your PC simply by pressing the buttons with the icons. The problem with these is the price tag, for a couple of college students, this much:


<img width="108" height="88" alt="image" src="https://github.com/user-attachments/assets/640fce5d-35fb-453d-9069-ab040d4600e8" />

is simply too much... No matter how cool a device it may be...

So, while disappointed, we took a look around and decided to do something about it. And, an Amazon Echo Show was the closest thing that fit the bill for what we needed, so we made an app for the Amazon Echo Dot that acts
like a Streamdeck, giving you a 2x4 grid of buttons that allow you to control applications on your PC. 

Yes, we made a Streamdeck app for an Amazon Echo. You're welcome. 

# How to use it

First, your Echo will need to be changed from FireOS to something a bit more open. Please follow these instructions to install LineageOS on the Echo, and be free at last:
https://xdaforums.com/t/unlock-root-twrp-unbrick-amazon-echo-show-5-2nd-gen-2021-cronos.4772596/
^ These are for the Echo 2nd gen, the link for the 1st gen can be found in the same post.

Once LineageOS is installed on your device, enable Developer mode on the device (this will need Googling, but it is a simple process) and enable ADB debugging. This will allow the app to be installed from Android Studio.

Next, Android Studio will need to be installed, and this repository will need to be downloaded and opened as a project in Android Studio. 

Once the project is opened, the companion application will need to be downloaded and run on another PC (the host computer), found [here](https://github.com/pixlperfect01/Echo-Show-Streamdeck-Companion). Please follow the instructions found in
the other repository. Additionally, the host PC and the Amazon Echo Show will need to be paired via Bluetooth before the companion script or the Streamdeck app are run. 

Once the host PC is paired to the Echo, and the companion application is running, use Android Studio to upload and run the application. This will install the application on the Echo, meaning future uses will not need Android Studio. 

Now you have your own Streamdeck!

# What it features

This repo contains a very early release of the Streamdeck app made at RowdyHacks. It is intended as a fun project and proof of concept.

