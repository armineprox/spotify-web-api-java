package com.wrapper.spotify.requests.data.library;

import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonArray;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.AbstractDataRequest;

import java.io.IOException;

public class SaveAlbumsForCurrentUserRequest extends AbstractDataRequest {

  private SaveAlbumsForCurrentUserRequest(final Builder builder) {
    super(builder);
  }

  public void put() throws
          IOException,
          SpotifyWebApiException {
    putJson();
  }

  public SettableFuture putAsync() throws
          IOException,
          SpotifyWebApiException {
    return executeAsync(putJson());
  }

  public static final class Builder extends AbstractDataRequest.Builder<Builder> {

    public Builder(final String accessToken) {
      super(accessToken);
    }

    public Builder ids(final String ids) {
      assert (ids != null);
      assert (ids.split(",").length <= 50);
      return setQueryParameter("ids", ids);
    }

    public Builder ids(final JsonArray ids) {
      assert (ids != null);
      assert (!ids.isJsonNull());
      return setBodyParameter("ids", ids);
    }

    @Override
    public SaveAlbumsForCurrentUserRequest build() {
      setPath("/v1/me/albums");
      return new SaveAlbumsForCurrentUserRequest(this);
    }
  }
}
