# 来源与制作 / Sources and contributors

This standalone edition is extracted from the aircraft implementation in [Overprotocol](https://github.com/XCNXNXNX/overprotocol). B-2 modeling and implementation: GPT-6Astra; concept, in-game testing, and recording: XCNXNXNX. Original project concept collaborators include DeepSeekV4.1Flash. Standalone packaging: GPT-6.1Sol.

The original procedural mesh is in B2Mesh.java; dimensions and body sections are in B2Geometry.java, with articulated geometry in B2Gear.java. The model, textures, and implementation are included as editable project sources. The Gradle Wrapper derives from the NeoForge MDK; its template notice is retained in TEMPLATE_LICENSE.txt.

Public dimension references: [USAF B-2 fact sheet](https://www.af.mil/About-Us/Fact-Sheets/Display/Article/104482/b-2-spirit/), [National Museum of the USAF](https://www.nationalmuseum.af.mil/Visit/Museum-Exhibits/Fact-Sheets/Display/Article/195832/USAFmuseum/northrop-b-2-spirit/). The approximate game speed setting follows the public high-subsonic range rather than a full physical simulation.

Implementation study included [Immersive Aircraft](https://github.com/Luke100000/ImmersiveAircraft), [Do a Barrel Roll](https://codeberg.org/enjarai/do-a-barrel-roll), and FlightGear aircraft part layouts. These are design references; their code and assets are not included in this mod.
