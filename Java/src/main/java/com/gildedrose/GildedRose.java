package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.contains("Sulfuras")) {
                if (!items[i].name.equals("Aged Brie") && !items[i].name.contains("Backstage passes")) {
                    if (items[i].quality > 0) {
                        items[i].quality--; 
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality++;

                        if (items[i].name.contains("Backstage passes") && items[i].quality < 49 && items[i].sellIn < 11) {
                        	if (items[i].sellIn >= 6 && items[i].sellIn <= 10) {
                                    items[i].quality++;
                        	} else {
                        		items[i].quality = items[i].quality + 2;
                        	}
                        }
                    }
                }

                items[i].sellIn--;
            }

            if (items[i].sellIn < 0 && !items[i].name.contains("Sulfuras")) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.contains("Backstage passes") && items[i].quality > 0) {
                        	items[i].quality--;
                    } else {
                        items[i].quality = 0;
                    }
                } else if (items[i].quality < 50) {
                        items[i].quality++;
                }
            }
        }
    }
}