
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifml3.sample.impl;

import ifml3.sample.ColoredRectangle;
import org.drombler.acp.core.action.ToggleAction;
import org.drombler.acp.core.action.ToggleMenuEntry;
import org.drombler.acp.core.action.ToolBarToggleEntry;


@ToggleAction(id = "redRectangle", category = "test", displayName = "%redRectangle.displayName", accelerator = "Shortcut+R",
icon = "red-rectangle.png")
@ToggleMenuEntry(path = "Custom", position = 1200)
@ToolBarToggleEntry(toolBarId = "rectangle", position = 150)
public class RedRectangleAction extends AbstractColoredRectangleAction {

    public RedRectangleAction() {
        super(ColoredRectangle.RED);
    }
}
