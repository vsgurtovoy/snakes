package snakes.modules;

import snakes.gameworld.GameRenderer;
import snakes.gameworld.GameWorld;


import java.io.File;
import javax.swing.JFileChooser;

public class ModuleEngine {

  public static void main(String args[], GameRenderer gr, GameWorld gw) {

    JFileChooser fileopen = new JFileChooser("C:\\Users\\sanis\\Documents\\snakes\\core\\build\\classes\\main\\snakes\\gameworld");
    int ret = fileopen.showDialog(null, "Загрузить");
    String moduleName = null;
    String modulePath = null;
    if (ret == JFileChooser.APPROVE_OPTION) {
        File file = fileopen.getSelectedFile();
        moduleName = file.getName().split("\\.class")[0];
        modulePath = (String)file.getPath();
    }

    ModuleLoader loader = new ModuleLoader(modulePath, ClassLoader.getSystemClassLoader());

    try {
            System.out.print("Executing loading module: ");
            System.out.println(moduleName);

            Class c = loader.loadClass("snakes.gameworld."+moduleName);
            Module execute = (Module) c.newInstance();

            execute.load(gr, gw, execute);
            execute.unload();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

  }

}