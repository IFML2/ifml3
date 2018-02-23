
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

@Menu(id = "Custom", displayName = "%customMenu.displayName", position = 110)
@Menu(id = "Sub", displayName = "%subMenu.displayName", path = "Custom", position = 30)
@ToolBar(id = "rectangle", displayName = "%rectangleToolBar.displayName", position = 50)
@ToolBar(id = "circle", displayName = "%circleToolBar.displayName", position = 100)
package ifml3.sample.impl;

import org.drombler.acp.core.action.Menu;
import org.drombler.acp.core.action.ToolBar;
