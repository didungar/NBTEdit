# NBTEdit
>Current Version: 0.1

<img align="centre" alt="Project Image" width="175px" src="https://i.imgur.com/5Igpcyn.png" />

<br />

> Spigot based plugin in order to allow viewing and editing of Player NBT tags through a simple command.

---

### Contents
- [Description](#description)
- [Usage](#usage)
- [Commands](#commands)
- [Permissions](#permissions)
- [Links](#links)

---

## Description

NBTEdit is a plugin which allows the ability to view and modify player NBT tags in a live-environment with a single easy-to-use command.

The theory behind this plugin is that for certain events that may require manual intervention relating to NBT tags, the plugin will allow this with little-hassle to the administrator and removes the requirement for any other plugins or changes.

## Commands

#### NBT Player Commands
The following commands allow those with permissions to view and edit NBT Player data.
The commands are all accessible through the command alias " ***/nbtp*** "

- **/nbtplayer set (plugin) (player) (tag) (value)**
  - Change the value of a tag for the specified player.
- **/nbtplayer view (plugin) (player) (tag)**
  - View the value of the tag for the specified player.
- **/nbtplayer check (plugin) (player) (tag)**
  - Check if the specified player has the tag.
    
#### NBT Item Commands
The following command allow those with permissions to view and edit NBT Item data.
The commands are all acciessible through the command alias " ***/nbti***"

- Arguments:
  - s:  Refers to a value of a String.
  - i:  Refers to a value of an Integer.
  - b:  Refers to a value of a Boolean.
  

- **/nbtitem set (tag) ([s:i:b:]value)**
  - Change the value of a tag for the specified player.
- **/nbtitem view ([s:i:b:]tag)**
  - View the value of the tag for the specified player.
- **/nbtitem check (tag)**
  - Check if the specified player has the tag.
  
**Example**
```
/nbtitem set enabled b:true
/nbtitem view b:enabled
/nbtitem check enabled
```

## Permissions

There is only a single permission required to operate NBTEdit as it is intended as an administration tool.

- **nbtedit.admin**
  - This admin permission allows the user access to all features of the plugin.

---

## Links

Useful links for this plugin!

You can find all the releases for this plugin [Here](https://github.com/Retrixa/NBTEdit/releases)

If you find this plugin a useful addition to your server, consider [buying a coffee](https://www.buymeacoffee.com/retrixa) for the developers!

You can find support for this plugin at our Official Discord [Here](https://discord.com/invite/KNFD3KdfEA)

Thank you!