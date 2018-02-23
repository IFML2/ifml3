
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifml3.sample.impl;

import ifml3.sample.ColoredCircle;
import org.drombler.acp.core.action.ToggleAction;
import org.drombler.acp.core.action.ToggleMenuEntry;
import org.drombler.acp.core.action.ToolBarToggleEntry;


@ToggleAction(id = "blueCircle", category = "test", displayName = "%blueCircle.displayName", accelerator = "Shortcut+U",
icon = "blue-circle.png")
@ToggleMenuEntry(path = "Custom/Sub", position = 30, toggleGroupId = "circle")
@ToolBarToggleEntry(toolBarId = "circle", position = 30, toggleGroupId = "circle")
public class BlueCircleAction extends AbstractColoredCircleAction {

    public BlueCircleAction() {
        super(ColoredCircle.BLUE);
    }
}
