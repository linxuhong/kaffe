package java.awt;

import java.awt.event.KeyEvent;
import java.util.Hashtable;

/**
 * Defaults - adaption parameters of package java.awt. This is our way to
 * parameterize various settings like colors and fonts. We prefer a simple
 * Java class (in favor of properties) because it doesn't need file system
 * access, is much faster, and more robust.
 *
 * Be very carefully to add additional java.awt types, since this might
 * introduce recursive class init problems. This is especially
 * true if static fields of such classes are involved (like Color), since
 * they might be still "null" (if they in turn refer to Toolkit/Defaults)
 * when referenced inside of this class.
 *
 * Copyright (c) 1998
 *      Transvirtual Technologies, Inc.  All rights reserved.
 *
 * See the file "license.terms" for information on usage and redistribution 
 * of this file. 
 *
 * @author P.C.Mehlitz
 */
class Defaults
{
/**
 * If ConsoleClass is set to the classname of a kaffe.util.log.LogClient, System.out, err
 * are redirected to a kaffe.util.log.LogStream, which notifies the provided LogClient
 * (usually a simple Window displaying scrolled text). If ConsoleClass is null, no
 * io redirection is performed
 */
	static String ConsoleClass = /*"kaffe.util.log.SimpleLogViewer" */ null;
/**
 * If set to 'true', the last Window that is closed will automatically
 * call a System.exit()
 */
	static boolean AutoStop = true;
/**
 * Upper bound (in ms) between mouse button press events which will be
 * considered as a 'click' (will increase the MouseEvent clickCount)
 */
	static int ClickInterval = 250;
/**
 * Sleep time (in ms) between native getNextEvent calls (= event polling rate).
 * Just used in case the native layer does not support blocked IO.
 */
	static int EventPollingRate = 30;
/**
 * Delay (in ms) between background native flush calls (from the flush thread) in case
 * the native layer needs flushing (queued graphics systems like X). This is only
 * required for apps doing graphics output outside the event dispatch thread, and for
 * native layers doing blocked IO (in this case the background drawing wouldn't appear
 * until something is going on in the dispatcher thread)
 */
	static int GraFlushRate = 250;
/**
 * Physical screen size in 1/10 inches (used for scaling purposes, e.g. fr printing)
 */
	static int ScreenSize = 130;
/**
 * just a shadow from the Defaults screen width (computed by the native layer)
 */
	static int ScreenWidth;
/**
 * just a shadow from the Defaults screen height (computed by the native layer)
 */
	static int ScreenHeight;
/**
 * screen resolution (in dpi), to be used for printing
 */
	static int XResolution;
/**
 * screen resolution (in dpi), to be used for printing
 */
	static int YResolution;
/**
 * Pixel height of MenuBars
 */
	static int MenuBarHeight = 20;
/**
 * Frame decoration extends (titlebar, size-borders) in pixels. For native windowing
 * systems (like X) this is just a guess, to be used for the first Frame to be opened,
 * and later on corrected (Frame.frameDeco). For standalone envionments, this is
 * an order
 */
	static Insets FrameInsets = new Insets( 24,4,4,4);
/**
 * Dialog decoration extends (titlebar, size-borders) in pixels. For native windowing
 * systems (like X) this is just a guess, to be used for the first Dialog to be opened,
 * and later on corrected (Dialog.dialogDeco). For standalone envionments, this is
 * an order
 */
	static Insets DialogInsets = new Insets( 24, 4, 4, 4);
/**
 * Native font description string for Default font. This can be used to customize fonts
 */
	static String FsDefault;
/**
 * Native font description string for Monospaced font. This can be used to customize fonts
 */
	static String FsMonospaced;
/**
 * Native font description string for SansSerif font. This can be used to customize fonts
 */
	static String FsSansSerif;
/**
 * Native font description string for Serif font. This can be used to customize fonts
 */
	static String FsSerif;
/**
 * Native font description string for Dialog font. This can be used to customize fonts
 */
	static String FsDialog;
/**
 * Native font description string for DialogInput font. This can be used to customize fonts
 */
	static String FsDialogInput;
/**
 * Native font description string for ZapfDingbats font. This can be used to customize fonts
 */
	static String FsZapfDingbats;
/**
 * This is a (priority-based) array of Java ARGB values for colors that should
 * be matched exactly. It is only used in PseudoColor visuals (256 color modes),
 * where we have to approximate Java 8-8-8 RGB colors by scarce colorcells.
 */
	static int[] RgbRequests = {
	// !!! this has to be initialized before any Color usage

	195<<16 | 195<<8 | 195,     // lightgray
	230<<16 | 230<<8 | 230,     // lighter lightGray
	163<<16 | 163<<8 | 163,     // darker lightGray
	190<<16                     // dark red
};
/**
 * Color used to mark the focus Component (border)
 */
	static Color FocusClr = new Color( 191, 0, 0);
/**
 * Default foreground color for Windows
 */
	static Color WndForeground = Color.black;
/**
 * Default background color for Windows
 */
	static Color WndBackground = Color.lightGray;
/**
 * Default font for Windows
 */
	static Font WndFont;
/**
 * metrics of the WndFont (computed)
 */
	static FontMetrics WndFontMetrics;
/**
 * Default font for menus
 */
	static Font MenuFont;
/**
 * Default text color for menus
 */
	static Color MenuTxtClr = Color.black;
/**
 * Text color of selected meu item
 */
	static Color MenuSelTxtClr = FocusClr;
/**
 * Default background color for menus
 */
	static Color MenuBgClr = Color.lightGray;
/**
 * If set to 'true', menu text will be drawn "carved" (with a down-right highlight)
 */
	static boolean MenuTxtCarved = true;
/**
 * Default text font
 */
	static Font TextFont;
/**
 * Default TextArea background color
 */
	static Color TextAreaBgClr = Color.white;
/**
 * Default TextArea text color
 */
	static Color TextAreaTxtClr = Color.black;
/**
 * Default TextArea font
 */
	static Font TextAreaFont;
/**
 * Default TextArea selection background color
 */
	static Color TextAreaSelBgClr = Color.lightGray;
/**
 * Default TextArea selection text color
 */
	static Color TextAreaSelTxtClr = Color.black;
/**
 * TextArea focus cursor color
 */
	static Color TextCursorClr = Color.blue;
/**
 * TextArea inactive (non-focus) cursor color
 */
	static Color TextCursorInactiveClr = Color.gray;
/**
 * If set to 'true', non-focused TextAreas keep their cursor displayed (in inactive color)
 */
	static boolean ShowInactiveCursor = false;
/**
 * If set to 'true', ScrollBars can get focus
 */
	static boolean FocusScrolls = false;
/**
 * Default TextField background color
 */
	static Color TextFieldBgClr = Color.white;
/**
 * Default TextField text color
 */
	static Color TextFieldTxtClr = Color.black;
/**
 * Default TextField selection background color
 */
	static Color TextFieldSelBgClr = Color.lightGray;
/**
 * Default TextField text color
 */
	static Color TextFieldSelTxtClr = Color.black;
/**
 * Default TextField font
 */
	static Font TextFieldFont;
/**
 * Default List font
 */
	static Font ListFont;
/**
 * Default List background color
 */
	static Color ListBgClr = new Color( 223, 223, 223);
/**
 * Default Lis text color
 */
	static Color ListTxtClr = Color.black;
/**
 * List selection background color
 */
	static Color ListSelBgClr = new Color( 163, 163, 163);
/**
 * List selection text color
 */
	static Color ListSelTxtClr = Color.black;
/**
 * List fly-over background color (item under mouse pointer)
 */
	static Color ListFlyOverBgClr = new Color( 214, 214, 214);
/**
 * List fly-over text color (item under mouse pointer)
 */
	static Color ListFlyOverTxtClr = Color.black;
/**
 * If set to 'true', fly-over items will be drawn with an inset border
 * (outset otherwise)
 */
	static boolean ListFlyOverInset = false;
/**
 * Default Label text color
 */
	static Color LabelClr = Color.black;
/**
 * Default Label font
 */
	static Font LabelFont;
/**
 * If set to 'true', Label text will be drawn carved (with right-down highlight)
 */
	static boolean LabelTxtCarved = true;
/**
 * Default background color for Buttons
 */
	static Color BtnClr = new Color( 163, 163, 163);
/**
 * Default text color for Buttons
 */
	static Color BtnTxtClr = Color.black;
/**
 * Button background color if button is under mouse pointer
 */
	static Color BtnPointClr = new Color( 180, 180, 180);
/**
 * Button text color if button is under mouse pointer
 */
	static Color BtnPointTxtClr = FocusClr;
/**
 * Default font for Buttons
 */
	static Font BtnFont;
/**
 * If set to 'true', Button text will be drawn carved (with right-down highlight)
 */
	static boolean BtnTxtCarved = true;
/**
 * Color for Component borders
 */
	static Color BorderClr = new Color( 159, 159, 159);
/**
 * Name of RootWindow (screen) class. Only used in standalone environments
 */
	static String RootWindowClass = "java.awt.RootWindow";
/**
 * Background color for RootWindow (stand-alone environments only)
 */
	static Color RootWindowClr = Color.blue;
/**
 * Image filename to be used to tile RootWindow background (only for standalone environments)
 */
	static String RootWindowImg = "marble.jpg";
/**
 * Name of KeyTable translation class (only used in standalone environments)
 */
	static String KeyTabClass = "java.awt.KeyTabGr";
/**
 * Color for active window borders (only used in standalone environments)
 */
	static Color WndActiveClr = new Color( 191, 0, 0);
/**
 * Color for active window titlebar background (only used in standalone environments)
 */
	static Color WndActiveTitleClr = Color.yellow;
/**
 * Color for inactive window borders (only for standalone environments)
 */
	static Color WndInactiveClr = Color.lightGray;
/**
 * Color for inactive window titlebar background (only used in standalone environments)
 */
	static Color WndInactiveTitleClr = Color.black;
/**
 * Name of class to be used to control desktop pages and controls (only for
 * standalone environments)
 */
	static String ControlBoxClass = "java.awt.WinTaskBar";
/**
 * Name of class to be used to display and control minimized windows (only for
 * standalone environments)
 */
	static String MinBoxClass = "java.awt.WinTaskBar";
/**
 * Maximum size of image files to be produced immediately (when the corrseponding
 * image is created). Images with files exceeding this size will be produced
 * asynchronously on demand
 */
	static int FileImageThreshold = Integer.MAX_VALUE;
/**
 * Maximum size of image data buffers to be produced immediately (when the corrseponding
 * image is created). Images with data buffers exceeding this size will be produced
 * asynchronously on demand
 */
	static int DataImageThreshold = Integer.MAX_VALUE;
/**
 * Maximum size of MemoryImageSource data to be produced immediately (when the
 * corrseponding image is created). Images with data buffers exceeding this
 * size will be produced asynchronously on demand (currently, everything != 0
 * will cause async production)
 */
	static int MemImageSrcThreshold = Integer.MAX_VALUE;
	static int RecycleEvents = 0;

static {
	// these are the computed values
	Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();

	ScreenWidth  = sd.width;
	ScreenHeight = sd.height;

	// HACK HACK HACK XXX
	if (ScreenSize == 0) {
		ScreenSize = 130;
	}
	
	// we assume a 4:3 width/height ratio of the display
	XResolution = (int)((double) ScreenWidth  * 10 / ( 0.8 * ScreenSize)); // dpi
	YResolution = (int)((double) ScreenHeight * 10 / ( 0.6 * ScreenSize)); // dpi
	
	String version = Toolkit.tlkVersion();
	if ( version.startsWith( "grx") ) {
		FsDefault = "helv%d%s%s.fnt";
		FsMonospaced = "xm7x13b.fnt";
		FsSansSerif = "helv%d%s%s.fnt";
		FsSerif = "tms%d%s%s.fnt";
		FsDialog = "cour%d%s%s.fnt";
		FsDialogInput = "cour%d%s%s.fnt";
		FsZapfDingbats = "helv%d%s%s.fnt";
	}
	else if ( version.startsWith( "X") ) {
		//FsDefault = "-b&h-lucida-%s-%s-*-*-%d-*-*-*-*-*-*-*";
		FsDefault = "-adobe-helvetica-%s-%s-*-*-%d-*-*-*-*-*-*-*";
		FsMonospaced = "-adobe-courier-%s-%s-*-*-%d-*-*-*-*-*-*-*";
		FsSansSerif = "-adobe-helvetica-%s-%s-*-*-%d-*-*-*-*-*-*-*";
		FsSerif = "-adobe-times-%s-%s-*-*-%d-*-*-*-*-*-*-*";
		FsDialog = "-misc-fixed-%s-%s-*-*-%d-*-*-*-*-*-*-*";
		FsDialogInput = "-b&h-lucidatypewriter-%s-%s-*-*-%d-*-*-*-*-*-*-*";
		FsZapfDingbats = "-adobe-new century schoolbook-%s-%s-*-*-%d-*-*-*-*-*-*-*";
	}
	else {
		// no idea, we have to leave it for the native layer
		FsDefault = "Default";
		FsMonospaced = "Monospaced";
		FsSansSerif = "SansSerif";
		FsSerif = "Serif";
		FsDialog = "Dialog";
		FsDialogInput = "DialogInput";
		FsZapfDingbats = "ZapfDingbats";
	}

	WndFont = new Font( "Default", Font.BOLD, 12);
	MenuFont = new Font( "Default", Font.BOLD, 11);
	TextFont = new Font( "Default", Font.BOLD, 12);
	TextAreaFont = new Font( "Dialog", Font.BOLD, 12);
	TextFieldFont = new Font( "Default", Font.BOLD, 12);
	ListFont = new Font( "Default", Font.BOLD, 12);
	LabelFont = new Font( "Default", Font.BOLD, 11);
	BtnFont = new Font( "Default", Font.BOLD, 11);
	
	WndFontMetrics = Toolkit.getDefaultToolkit().getFontMetrics( WndFont);

	String banner = System.getProperty( "banner", "banner.gif");
	Toolkit.tlkDisplayBanner(banner);
}
}
