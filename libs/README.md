# 本地依赖

`build.gradle` 通过 `flatDir` 以 `blank:<artifact>:<version>` 坐标引用本目录中的 9 个 JAR。文件完整性基线见 `SHA256SUMS`。

这些文件在当前项目中没有上游下载地址、仓库或发布页记录。为避免伪造供应链来源，发布前必须由维护者核对原始下载来源，并确认其与 `SHA256SUMS` 一致。
