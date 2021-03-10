package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        //Approvals.verify(app.items[0].name);
        
    }
    
    
    @Test
    void decreaseQuality() {
    	
    	Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    	
    }
    
    @Test
    void increaseQualityForAged_Brie() {
    	
    	Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    	
    }
    
    @Test
    void increaseQualityElixirMongoose() {
    	
    	Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    	
    }
    

    @Test
    void updateQualitySulfurasHandRagnaros(){
    	
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    	
    }

    @Test
    void should_decrease_quality_twice_as_fast_when_sell_date_has_passed(){

        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(78, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

    }

    @Test
    void should_increase_quality_as_selling_value_approaches(){

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void should_increase_quality_by_2_as_selling_value_approaches(){

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void should_increase_quality_by_3_as_selling_value_approaches(){

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void should_quality_never_be_more_than_50(){

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

    }

    @Test
    void should_quality_never_be_more_than_50_for_Aged_Brie(){

        Item[] items = new Item[] { new Item("Aged Brie", 8, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
    }

    @Test
    void should_quality_never_be_less_than_0(){

        Item[] items = new Item[] { new Item("Aged Brie", 8, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
    }

    @Test
    void should_quality_drops_to_0_after_concert(){

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void agedBrie_sellIn_Equals_0(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }
}
