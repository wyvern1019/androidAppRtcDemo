/*
 *  Copyright 2017 The WebRTC project authors. All Rights Reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package org.webrtc;


import androidx.annotation.Nullable;

/** Factory for creating VideoEncoders. */
public interface VideoEncoderFactory {
  /** Creates an encoder for the given video codec. */
  @Nullable
  @CalledByNative VideoEncoder createEncoder(VideoCodecInfo info);

  /**
   * Enumerates the list of supported video codecs. This method will only be called once and the
   * result will be cached.
   */
  @CalledByNative VideoCodecInfo[] getSupportedCodecs();

  /**
   * Enumerates the list of supported video codecs that can also be tagged with
   * implementation information. This method will only be called once and the
   * result will be cached.
   */
  @CalledByNative
  default VideoCodecInfo[] getImplementations() {
    return getSupportedCodecs();
  }
}
