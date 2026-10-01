# 构建验证 / Build validation

2026-10-01，Windows，Java 21，Minecraft 1.21.1，NeoForge 21.1.197。

```powershell
.\gradlew.bat build runGameTestServer exportB2Model --offline --console=plain
```

- 构建成功；17 项必需 GameTest 全部通过。
- 实例仅加载 Minecraft、NeoForge 和 B-2 Spirit；无需完整 Overprotocol。
- 起落架与舱门检查覆盖 41 个姿态、882648 个顶点；净空和连接检查通过。
- 网格整体尺寸约 52.12 × 5.096 × 20.9 格，地面接触点 Y≈0。
- 发行 JAR 不包含完整模组的类、开发 GameTest 类或测试结构。
- 中英语言键一致；补全按键分类名称后再次构建成功。

The build succeeded and all 17 required GameTests passed with only Minecraft, NeoForge, and B-2 Spirit loaded. Gear/door verification covered 41 poses and 882648 vertices, passing clearance and joint checks. The mesh measures approximately 52.12 × 5.096 × 20.9 blocks, with ground contact at Y≈0. The installable JAR contains no full-mod classes or development test content. English and Chinese language keys match; a rebuild after completing the key category translation also succeeded.

首次构建需要联网下载依赖；上述命令使用已有缓存。游戏外观、驾驶感受和真实 TaCZ 兼容性由玩家继续检验。

The offline command used an existing dependency cache; a first build requires network access. Appearance, flight feel, and compatibility with the real TaCZ mod remain player checks.
