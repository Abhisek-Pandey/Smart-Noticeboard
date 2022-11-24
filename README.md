
<h1 align="center">Smart Noticeboard</h1>


<h3 align="center">
  <a href="https://mail.google.com/mail/u/0/?fs=1&to=abhisek.pandey.1289@gmail.com&su=Feature%20Request%20for%20Smart%20NoticeBoard&body=I%20would%20like%20that%20you%20would%20include%20&bcc=pandey240600@gmail.com&tf=cm">Feature request</a>
  <span> · </span>
  <a href="https://mail.google.com/mail/u/0/?fs=1&to=abhisek.pandey.1289@gmail.com&su=Bug%20Detected%20in%20Smart%20NoticeBoard&body=I%20saw%20this%20bug%20&bcc=pandey240600@gmail.com&tf=cm">Report a bug</a>
  <span> · </span>
  Support: <a href="https://t.me/abhisekJii">Discussions</a>

</h3>

### Overview:
Display all the Notices on a screen from anywhere with a Telegram channel
### Support:
| Category | Support |
|--|--|
|Language | `Python 3.7` and above,  `Java 17`|
|Supported media types|   document, photo, video|

### ToDo:
- Reducing the Bandwidth required.
- Better UI

### Installation

1. Download the ` Repositories ` as Zip. 
2. Boot to `Raspberry Pi` 
3. Install `Python 3.7` and `Java 1.8 or Higher`
4. Save the ` Repositories ` and Extract all its contents.
5. Run **` pip install -r requirements.txt `** in `Terminal` as same directory as the Extracted files above.
6. Create a shell file to run **` java SmartNoticeBoard `**.
7. Set the Shell file to be executed every time the Raspberry Pi boots(varies from Raspberry OS and Methods you choose as you need).

## Configuration

All the configurations are  passed to the Smart Noticeboard via `config.yaml` file.

**Getting your API Keys:**
The very first step requires you to obtain a valid Telegram API key (API id/hash pair):
1.  Visit  [https://my.telegram.org/apps](https://my.telegram.org/apps)  and log in with your Telegram Account.
2.  Fill out the form to register a new Telegram application.
3.  Done! The API key consists of two parts:  **api_id**  and  **api_hash**.


**Getting chat id:**

**1. Using web telegram:**
1. Open https://web.telegram.org/?legacy=1#/im
2. Now go to the chat/channel and you will see the URL as something like
	- `https://web.telegram.org/?legacy=1#/im?p=u853521067_2449618633394` here `853521067` is the chat id.
	- `https://web.telegram.org/?legacy=1#/im?p=@somename` here `somename` is the chat id.
	- `https://web.telegram.org/?legacy=1#/im?p=s1301254321_6925449697188775560` here take `1301254321` and add `-100` to the start of the id => `-1001301254321`.
	- `https://web.telegram.org/?legacy=1#/im?p=c1301254321_6925449697188775560` here take `1301254321` and add `-100` to the start of the id => `-1001301254321`.


**2. Using bot:**
1. Use [@username_to_id_bot](https://t.me/username_to_id_bot) to get the chat_id of
    - almost any telegram user: send username to the bot or just forward their message to the bot
    - any chat: send chat username or copy and send its joinchat link to the bot
    - public or private channel: same as chats, just copy and send to the bot
    - id of any telegram bot


### config.yaml
```yaml
api_hash: your_api_hash
api_id: your_api_id
chat_id: telegram_chat_id
last_read_message_id: 0
ids_to_retry: []
media_types:
- audio
- document
- photo
file_formats:
  audio:
  - all
  document:
  - pdf
  video:
  - mp4
  - mkv
  scheme: socks5
  hostname: 11.22.33.44
  port: 1234
  username: your_username
  password: your_password
```


- **api_hash**  - The api_hash you got from telegram apps
- **api_id** - The api_id you got from telegram apps
- **chat_id** -  The id of the chat/channel you want to download media. Which you get from the above-mentioned steps.
- **media_types** - Type of media to download, you can update which type of media you want to download it can be one or any of the available types.
- **file_formats** - File types to download for supported media types which are **`audio`**, **`document`** and **`video`**. Default format is **`all`**, downloads all files.
- **username** - Username associated with the **`API_id`** and **`chat_id`**
- **password** - passsword for the given Username

## Execution
After proper setup is done, every time the Pi boots up it will automatically run, and would start displaying the Notice Media files in loop




Requirement:
    - Raspberry Pi
    - Python
    - Java
    - apache libraries (Java)
    - PIL library (Python)
    - Tkinter Library
    - PyYAML==6.0
    - rich==12.5.1
    - TgCrypto==1.2.3



