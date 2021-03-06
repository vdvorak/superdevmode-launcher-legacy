/*
 * Copyright 2014 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.dev.shell;

import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.impl.StandardLinkerContext;
import com.google.gwt.dev.cfg.ModuleDef;

import java.net.URL;

/**
 * Common interface for code server listeners.
 */
public interface CodeServerListener {

  /**
   * @return the port number of the listening socket.
   */
  int getSocketPort();

  /**
   * Start the listener thread.
   */
  void start();

  /**
   * Returns the URL to use in the browser for using this codeserver.
   */
  URL processUrl(String url) throws UnableToCompleteException;

  /**
   * produces the browser output of one permutation.
   */
  void produceBrowserOutput(StandardLinkerContext linkerStack, ArtifactSet artifacts,
      ModuleDef module, boolean isRelink) throws UnableToCompleteException;

  /**
   * Set any created BrowserChannelServers to ignore remote deaths.
   * 
   * This is most commonly wanted by JUnitShell.
   */
  void setIgnoreRemoteDeath(boolean b);
}