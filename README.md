# B-2 Spirit / B-2 幽灵

<img src="src/main/resources/assets/b2spirit/textures/item/b2_spirit.png" alt="B-2 Spirit item texture" width="128">

**Minecraft Java 1.21.1 · NeoForge · Java 21**

## 中文

从 [顶格礼遇 / Overprotocol](https://github.com/XCNXNXNX/overprotocol) 中拆分的 B-2 独立载具模组，注册命名空间为 `b2spirit`，无需安装完整模组。

- 1 格约等于 1 米：翼展 52.12 格、机长 20.9 格、总高约 5.1 格。
- 原创曲面飞翼、座舱、进气口、喷口、底面轮舱、铰接起落架与轮舱门。
- 鼠标控制转向与俯仰，停止输入逐渐恢复平稳；滚轮/W/S 调节并保持油门。
- 双座、乘客模型隐藏，自动第三人称跟随与随速度增大的视野；下机恢复原视角。
- G 收放起落架，紧凑 HUD 显示速度、油门、轮架和操作提示。
- 空地右键部署、机身右键登机，停稳且无人乘坐时潜行右键机身回收；保留自定义名称。
- 下界之星居中，外围八个下界合金块合成。物品使用下界之星稀有度，防火并抵抗仙人掌伤害。
- 可选 TaCZ 持枪交互兼容；无需 TaCZ、JEI、光影或其他载具模组。

游戏最高速度约 1010 km/h；地面与放轮速度受限。碰撞检测近似机翼范围，飞行规则服务于游戏驾驶。完整版已包含飞机，通常选择完整模组或独立版即可；两版拥有不同物品 ID，不会自动迁移存档中的飞机。

## English

A standalone aircraft edition extracted from [Overprotocol](https://github.com/XCNXNXNX/overprotocol), using the `b2spirit` registry namespace. It does not require the complete mod.

- Life-size dimensions: 52.12-block wingspan, 20.9-block length, approximately 5.1 blocks tall.
- An original lofted flying-wing mesh with cockpit, intakes, exhausts, wheel bays, articulated landing gear, and sequenced doors.
- Mouse steering and pitch; neutral input gradually stabilizes flight. Wheel/W/S adjust a persistent throttle.
- Two seats, hidden rider models, an automatic third-person chase camera, and speed-sensitive field of view. Dismounting restores the previous perspective.
- G toggles gear; a compact HUD shows speed, throttle, gear, and controls.
- Right-click clear ground to deploy; right-click the fuselage to board. Sneak-right-click a stopped, unoccupied aircraft to recover it, retaining its custom name.
- Craft a nether star surrounded by eight netherite blocks. The item matches nether-star rarity, is fire resistant, and resists cactus damage.
- Optional TaCZ gun-interaction compatibility; no TaCZ, JEI, shader, or vehicle mod is required.

The game speed cap is approximately 1010 km/h, with lower ground and gear-down limits. Collision approximates the wings, and flight follows game rules. The complete Overprotocol edition already includes this aircraft, so normally choose one edition. The two editions have different item IDs and do not automatically migrate saved aircraft.

## 操作 / Controls

| 输入 / Input | 功能 / Action |
| --- | --- |
| Mouse | 转向、俯仰 / Steering and pitch |
| Wheel, W/S | 油门；S 在地面刹车 / Throttle; S brakes on ground |
| A/D, Space/Ctrl | 转向与俯仰辅助 / Steering and pitch assistance |
| G | 起落架 / Landing gear |
| Shift | 下机 / Dismount |
| Sneak + right-click | 停稳无人时回收 / Recover when stopped and empty |

## 构建 / Build

Install a Java 21 JDK, then run:

```sh
./gradlew build
./gradlew runGameTestServer
./gradlew exportB2Model
```

Windows: use `gradlew.bat`. The first build downloads dependencies; subsequent builds can use `--offline`. Development runs: `runClient`, `runServer`. Install the regular JAR from `build/libs/` into a Minecraft 1.21.1 NeoForge instance on both client and server; do not install the `-sources.jar`.

Aircraft code, mesh, textures, bilingual text, recipe, and automated aircraft tests are all included. The mesh source is `src/main/java/dev/b2spirit/client/B2Mesh.java`; `exportB2Model` exports OBJ/MTL and checks 41 gear/door poses. Runtime JARs exclude development GameTests and their structure template.

独立源码构建与 17 项 GameTest 已通过，详见 [验证记录 / Validation](docs/VALIDATION.md)。

## 制作 / Contributors

- B-2 建模与实现 / Aircraft modeling and implementation: GPT-6Astra
- 创意、游戏测试与实录 / Concept, in-game testing, and recording: XCNXNXNX
- 原项目创意协作 / Original project concept collaborators: DeepSeekV4.1Flash, GPT-6Astra
- 独立项目整理 / Standalone project packaging: GPT-6.1Sol

完整项目分工与视频工具见 [Overprotocol](https://github.com/XCNXNXNX/overprotocol)。技术参考见 [CREDITS.md](CREDITS.md)。
