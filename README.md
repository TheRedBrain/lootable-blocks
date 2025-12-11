# Lootable Blocks

An add-on for the Lootables mod that adds several blocks that supply lootables.

## Lootable Vault Block

This blocks works similar to the vanilla Vault Block, but instead of spawning the loot in item form above the block, the loot is supplied via Lootables.

The block configuration is data-driven.

Example:

> Note that the lootable and loot table identifiers used in these examples are placeholders.

```json5
{
  "lootable_identifier": "lootableblocks:test", // the identifier of the lootable_table
  "rolls": 3, // amount of rosls
  "choices": 1, // amount of choices
  "with_choice": true, // whether the lootable is presented as a choice
  "activation_range": 4.0, // must be >= 'deactivation_range'
  "deactivation_range": 4.5,
  "key_item": {
      "id": "minecraft:trial_key",
      "count": 1
  },
  "display_loot_table_identifier": "lootableblocks:chests/test" // the identifier of the display loot_table, refers to a vanilla loot table
}
```

Example /give command:

```
/give @s lootableblocks:lootable_vault_block[block_state={ominous:"false"},block_entity_data={id:"lootableblocks:lootable_vault_block",config_identifier:"lootableblocks:test"}]
```

## Interactive Loot Block

This block is a block intended for map-makers and server admins, and it's available in the operator items creative tab.

Interacting with it opens a config screen (when player is in creative mode and has permission level >= 2), where several config options can be set.

When interacted with in survival or adventure mode the block provides a lootable, according to its settings.
