package com.yourname.yourmod.api.libs.internal;

public final class ClientBuilder {

    private final RenderDSL render = new RenderDSL();
    private final KeybindDSL keybind = new KeybindDSL();
    private final ScreenDSL screen = new ScreenDSL();
    private final HudDSL hud = new HudDSL();

    public RenderDSL renders() { return render; }
    public KeybindDSL keybinds() { return keybind; }
    public ScreenDSL screens() { return screen; }
    public HudDSL hud() { return hud; }

    public void registerAll() {
        render.registerAll();
        keybind.registerAll();
        screen.registerAll();
        hud.registerAll();
    }
}