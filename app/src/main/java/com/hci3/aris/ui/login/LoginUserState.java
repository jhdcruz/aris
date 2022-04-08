package com.hci3.aris.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoginUserState {
    private final String displayName;
    //... other data fields that may be accessible to the UI

    LoginUserState(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}