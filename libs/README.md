# 本地依赖

`build.gradle` 通过 `flatDir` 以 `blank:<artifact>:<version>` 坐标引用本目录中的 8 个运行依赖 JAR。目录中另有未被构建依赖引用的 Fabric 客户端 JAR `I18nUpdateMod-1.20.1-3.7.0.jar`；它不得放入 Forge 运行目录。全部 9 个文件的完整性基线见 `SHA256SUMS`。

部分 JAR 的内嵌元数据含候选项目页或更新地址，但当前项目没有维护者确认的原始下载地址、文件 ID 与下载时间记录。为避免把二进制自述误当成供应链证明，发布前必须由维护者核对原始下载来源，并确认其与 `SHA256SUMS` 一致。
