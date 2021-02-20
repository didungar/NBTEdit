# NBTEdit
>Current Version: 1.0

<img align="centre" alt="Project Image" width="175px" src="https://i.imgur.com/5Igpcyn.png" />

<br />

> Spigot based plugin in order to allow viewing and editing of Item NBT tags through a simple command.

---

### Contents
- [Description](#description)
- [Usage](#usage)
- [Commands](#commands)
- [Permissions](#permissions)
- [Links](#links)
- [Credit](#credit)

---

## Description

NBTEdit is a plugin which allows the ability to view and modify Item NBT tags in a live-environment with a single easy-to-use command.

The theory behind this plugin is that for certain events that may require manual intervention relating to NBT tags, the plugin will allow this with little-hassle to the administrator and removes the requirement for any other plugins or changes.

## Commands
    
#### NBT Item Commands
The following command allow those with permissions to view and edit NBT Item data.
The commands are all acciessible through the command alias " ***/nbt*** "


- **/nbtedit set (tag) (value)**
  - Change the value of a tag for the specified player.
- **/nbtedit view (tag)**
  - View the value of the tag for the specified player.
- **/nbtedit check (tag)**
  - Check if the specified player has the tag.
  
**Examples**
```
/nbtedit set enabled true
/nbtedit view enabled
/nbtedit check enabled
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

---

## Credit

Credit to [BananaPuncher714](https://github.com/BananaPuncher714) for the resource [NBTEditor](https://github.com/BananaPuncher714/NBTEditor) that was used in this plugin!