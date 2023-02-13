package ifml3.app.file;

import java.nio.file.Path;

public interface AppFolders {

    Path userFolder();

    Path currentFolder();

    Path applicationFolder();
}
