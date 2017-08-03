# Pro-Essential

## V1.0.5

### 架构性更新
        1. 新增指令/invsee
           可以操作玩家的背包
        2. 新增指令/day
           将当前世界的时间设为白天
        3. 新增指令/night
           将当前世界的时间设为黑夜

### 功能性更新
        1. 回家可以通过GUI选择。

## V1.0.4

### 架构性更新
        1. 修改指令/tp
           现在可以传送到指定坐标

### 功能性更新
        1. 提示语言全面集成（尚未实现自定义）。

## V1.0.3

### 架构性更新
        1. 新增指令/sun
           将当前世界的天气设为晴天
        2. 新增指令/rain
           将当前世界的天气设为雨天
        3. 新增指令/ess reload
           重载配置文件
        4. 新增指令/tpall
           将所有玩家传送到身边

### 功能性更新
        1. 可自定义聊天格式。
        2. 修改了权限判定流程。
        3. 修复了传送时的玩家名判断问题。

## V1.0.2

### 架构性更新
        1. 新增指令/setspawn
           设置出生点
        2. 新增指令/heal
           治疗玩家

### 功能性更新
        1. 权限指令将在加载时写入未设置值得指令权限条目。
        2. 修复了插件加载顺序可能导致的问题。

### 数据性更新
        1. 更换了Permission文件的权限结构。

## V1.0.1

### 功能性更新
	1. 修复了Back, Home, Spawn 等涉及位置移动的指令或事件在异世界的处理问题。
	2. 当使用指令/home没有输入参数时将不再默认传送到第一个家，而是提示输入/home <id>。
	3. 玩家死亡时将记录死亡前的坐标。
	4. 改善了输出列表时的性能。

## V1.0.0

### 架构性更新
	1. 新增指令/back
	   回到上一传送位置
		   
	2. 新增指令/fly
	   更改玩家飞行模式
		   
	3. 新增指令/gm
	   更改玩家生存模式
		   
	4. 新增指令/spawn
	   回到默认出生点
		   
	5. 新增指令/speed
	   更改玩家飞行/步行速度
		   
	6. 新增指令/tp
	   传送到玩家身边
		   
	7. 新增指令/tpa
	   向其他玩家发送传送请求
		   
	8. 新增指令/tpaccept
	   同意其他玩家的传送请求/传送邀请
		   
	9. 新增指令/tpahere
	   向其他玩家发送传送邀请
		   
	10.新增指令/tpdeny
	   拒绝其他玩家的传送请求/传送邀请
		   
	11.新增指令/tphere
	   把某个玩家传送到自己身边
		   
	12.新增指令/home
	   回到家
		   
	13.新增指令/sethome
	   设置家
	
### 数据性更新
	1. 新增文件Permission.yml
	   设置指令权限（EveryOne, OP）
		   
	2. 新增文件spawn.yml
	   储存出生点数据
	   
### 管理性更新
	1. 新增配置Settings.MaxAmountOfHome
	   玩家设置家的数量上限