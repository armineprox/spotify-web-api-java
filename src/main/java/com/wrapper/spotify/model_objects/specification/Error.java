package com.wrapper.spotify.model_objects.specification;

import com.google.gson.JsonObject;
import com.wrapper.spotify.model_objects.AbstractModelObject;

/**
 * Retrieve information about <a href="https://developer.spotify.com/web-api/object-model/#error-object">
 * Error objects</a>by building instances from this class.
 */
public class Error extends AbstractModelObject {
  private final int status;
  private final String message;

  private Error(final Error.Builder builder) {
    super(builder);

    this.status = builder.status;
    this.message = builder.message;
  }

  /**
   * Get the <a href="https://developer.spotify.com/web-api/user-guide/#response-status-codes">HTTP status code</a>
   * of the {@link Error} object.
   *
   * @return The <a href="https://developer.spotify.com/web-api/user-guide/#response-status-codes">HTTP status code</a>.
   */
  public int getStatus() {
    return status;
  }

  /**
   * Get the error message (description of the cause) of the {@link Error} object.
   *
   * @return A short description of the cause of the error.
   */
  public String getMessage() {
    return message;
  }

  @Override
  public Builder builder() {
    return new Builder();
  }

  /**
   * Builder class for building {@link Error} instances.
   */
  public static final class Builder extends AbstractModelObject.Builder {
    private int status;
    private String message;

    /**
     * The error <a href="https://developer.spotify.com/web-api/user-guide/#response-status-codes">HTTP status
     * code</a> setter.
     *
     * @param status The <a href="https://developer.spotify.com/web-api/user-guide/#response-status-codes">
     *               HTTP status code</a>.
     * @return A {@link Error.Builder}.
     */
    public Builder setStatus(int status) {
      this.status = status;
      return this;
    }

    /**
     * The error message setter.
     *
     * @param message A short description of the cause of the error.
     * @return A {@link Error.Builder}.
     */
    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    @Override
    public Error build() {
      return new Error(this);
    }
  }

  /**
   * JsonUtil class for building {@link Error} instances.
   */
  public static final class JsonUtil extends AbstractModelObject.JsonUtil<Error> {
    public Error createModelObject(JsonObject jsonObject) {
      if (jsonObject == null || jsonObject.isJsonNull()) {
        return null;
      }

      return new Error.Builder()
              .setStatus(jsonObject.get("status").getAsInt())
              .setMessage(jsonObject.get("message").getAsString())
              .build();
    }
  }
}
