#VillagerUtils

Tools for managing villagers on Spigot servers

![Editing a villager trade](http://i.imgur.com/pBWpb0d.gif)

* Commands to edit villager trades and professions

* Log villager deaths with enough information to reasonably recreate them

## Commands

### /villager

* `/villager spawn [profession]` - Convenience command to spawn a new villager at your location, and optionally set its profession.

* `/villager name <name>` - Set the villager's name

* `/villager profession <profession>` - Set the villager's profession to any valid option.

* `/villager cleartrades` - Clear all trades from a villager. You won't even be able to open the trade UI until you add some new ones.

* `/villager addtrade` - Add a custom trade to the end of the stack. First you must have a trade in your workspace before you can apply it. (See `/vtrade` for further reference.)

### /vtrade

* `/vtrade new` - Create a new, blank trade

* `/vtrade items` - Open an inventory UI to insert 1-2 items for the "cost" and one item for the result of the trade.

* `/vtrade maxuses <int>` - Set how many times this trade can be used before it locks, requiring a player to refresh it by using other trades. A blank trade will default to a random number from 2-12, to mimic vanilla distribution. If this is for a "server merchant" or similar, you may specify a value of `max` for the highest available integer.

* `/vtrade experience <boolean>` - Set whether this trade will yield experience or not. (Default: true)