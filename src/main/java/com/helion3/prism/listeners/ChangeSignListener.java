/*
 * This file is part of Prism, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015 Helion3 http://helion3.com/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.helion3.prism.listeners;

import com.helion3.prism.Prism;
import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.data.manipulator.mutable.tileentity.SignData;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.block.tileentity.ChangeSignEvent;

public class ChangeSignListener {

  /**
   * Listens to the base change block event.
   *
   * @param event ChangeBlockEvent
   */
  @Listener(order = Order.POST)
  public void onChangeSign(ChangeSignEvent event) {
    if (event.getCause().first(Player.class).map(Player::getUniqueId).map(Prism.getInstance().getActiveWands()::contains).orElse(false)) {
      // Cancel and exit event here, not supposed to place/track a block with an active wand.
      event.setCancelled(true);
      return;
    }

    if (!Prism.getInstance().getConfig().getEventCategory().isSignChange()) {
      return;
    }
    Sign tileEntity = event.getTargetTile();

    // TODO implement

    // Get relevant data from this event -- namely, the changed sign data
    SignData originalSignData = tileEntity.getSignData();
    SignData finalSignData = event.getText();

    // Create prism record
//    PrismRecord.create()
//        .source(event.getCause())
//        .signOriginal(originalSignData)
//        .signReplacement(finalSignData)
//        .location(tileEntity.getLocation())
//        .event(PrismEvents.SIGN_CHANGE)
//        .target(tileEntity.getBlock().getId().replace("_", " "))
//        .buildAndSave();
  }
}
