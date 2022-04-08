package com.hci3.aris.ui.login;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private LoginUserState success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable LoginUserState success) {
        this.success = success;
    }

    @Nullable
    LoginUserState getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}