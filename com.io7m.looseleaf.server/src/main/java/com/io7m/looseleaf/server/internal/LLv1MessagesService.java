/*
 * Copyright © 2022 Mark Raynsford <code@io7m.com> https://www.io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package com.io7m.looseleaf.server.internal;

import com.io7m.looseleaf.protocol.v1.LLv1Messages;
import com.io7m.repetoir.core.RPServiceType;

/**
 * A message service for v1 protocol messages.
 */

public final class LLv1MessagesService implements RPServiceType
{
  private final LLv1Messages messages;

  /**
   * A message service for v1 protocol messages.
   */

  public LLv1MessagesService()
  {
    this.messages = new LLv1Messages();
  }

  /**
   * @return The message serializer/deserializer
   */

  public LLv1Messages messages()
  {
    return this.messages;
  }

  @Override
  public String description()
  {
    return "v1 Messages service.";
  }

  @Override
  public String toString()
  {
    return "[%s 0x%s]".formatted(
      this.getClass().getSimpleName(),
      Long.toUnsignedString(this.hashCode(), 16)
    );
  }
}
