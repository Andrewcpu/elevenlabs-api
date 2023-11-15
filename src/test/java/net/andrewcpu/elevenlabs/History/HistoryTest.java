package net.andrewcpu.elevenlabs.History;

import net.andrewcpu.elevenlabs.ElevenLabs;
import net.andrewcpu.elevenlabs.ElevenLabsTest;
import net.andrewcpu.elevenlabs.model.history.History;
import net.andrewcpu.elevenlabs.model.history.HistoryItem;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class HistoryTest extends ElevenLabsTest {

	@Test
	public void testGetHistory() {
		assertFalse("Failed to get history.", doesThrow(() -> {
			ElevenLabs.getHistoryAPI().getHistory();
		}));
	}

	@Test
	public void testGetHistoryItem() {
		History history = ElevenLabs.getHistoryAPI().getHistory();
		assertNotNull(history);
		List<HistoryItem> items = history.getHistoryItems();
		assertNotNull(items);
		assertTrue(items.size() != 0);
		HistoryItem item = history.getHistoryItems().get(0);
		assertFalse("Failed to get history item", doesThrow(() -> {
			ElevenLabs.getHistoryAPI().getHistoryItem(item.getHistoryItemId());
		}));
		assertFalse("Failed to download audio history.", doesThrow(() -> {
			File output = ElevenLabs.getHistoryAPI().getHistoryItemAudio(item.getHistoryItemId());
			output.delete();
		}));
		assertTrue(items.size() >= 2);
		HistoryItem item2 = history.getHistoryItems().get(1);

		assertFalse("Failed to download audio history (grouped).", doesThrow(() -> {
			File output = ElevenLabs.getHistoryAPI().getHistoryItemAudio(item.getHistoryItemId(), item2.getHistoryItemId());
			System.out.println(output.getName());
			output.delete();
		}));

	}
}
