package github.apjifengc.bingo.nms;

import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.PacketPlayInClientCommand;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class v1_16_R3 implements NMSBase {

	@Override
	public String getVersion() {
		return "v1_15_R1";
	}

	@Override
	public void respawnPlayer(Player player) {
		if (player.isDead()) {
			((CraftPlayer) player).getHandle().playerConnection
					.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
		}
	}

	@Override
	public String getItemName(ItemStack is) {
		return IChatBaseComponent.ChatSerializer.a("{\"translate\":\""
				+ org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack.asNMSCopy(is).getItem().getName() + "\"}")
				.getText();
	}

	@Override
	public String getEntityName(Entity entity) {
		return IChatBaseComponent.ChatSerializer.a("{\"translate\":\""
				+ entity.getName() + "\"}")
				.getText();
	}
}
