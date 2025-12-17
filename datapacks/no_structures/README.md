# 长生诀结构禁用数据包
# Chang Sheng Jue - No Structures Datapack

## 简介 | Description

这个数据包可以禁用长生诀模组中的所有结构生成。

This datapack disables all structure generation from Chang Sheng Jue mod.

## 禁用的结构 | Disabled Structures

- 徽派村庄 (Hui Pai Village)
- 苏派村庄 (Su Pai Village)
- 四合院村庄 (Si He Yuan Village)
- 城池 (Fortresses)
- 沙石城堡 (Sandstone Castle)
- 练武场 (Pit Yard)

## 安装方法 | Installation

### 方法1：服务器/单人游戏世界
1. 将整个 `禁用长生诀模组结构生成数据包.zip` 文件复制到你的世界存档的 `datapacks` 文件夹中
   - 单人游戏路径: `.minecraft/saves/[世界名称]/datapacks/`
   - 服务器路径: `[服务器目录]/[世界名称]/datapacks/`

2. 重新加载数据包:
   - 在游戏中输入命令: `/reload`
   - 或者重启游戏/服务器

## 验证安装 | Verification

在游戏中输入命令:
```
/datapack list
```

你应该看到 `[file/禁用长生诀模组结构生成数据包]` 在启用的数据包列表中。

## 卸载方法 | Uninstallation

### 方法1：游戏内禁用
```
/datapack disable "file/禁用长生诀模组结构生成数据包"
```

### 方法2：删除文件
从 `datapacks` 文件夹中删除 `[禁用长生诀模组结构生成数据包]` 文件夹（或 ZIP 文件），然后重新加载世界。

## 注意事项 | Notes

- **重要**: 此数据包仅影响新生成的区块。已经生成的结构不会被删除。
- **Important**: This datapack only affects newly generated chunks. Existing structures will not be removed.

- 如需重新启用结构生成，只需禁用或删除此数据包。
- To re-enable structure generation, simply disable or remove this datapack.

- 此数据包不需要客户端安装，仅在服务器端或单人世界安装即可。
- This datapack doesn't need to be installed on clients, only on the server or in singleplayer worlds.

## 兼容性 | Compatibility

- Minecraft 版本: 1.20.1
- 数据包格式: 15
- 模组: 长生诀 (Chang Sheng Jue)