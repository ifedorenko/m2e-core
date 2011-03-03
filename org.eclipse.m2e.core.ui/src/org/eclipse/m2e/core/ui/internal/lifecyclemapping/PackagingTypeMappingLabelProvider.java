/*******************************************************************************
 * Copyright (c) 2008 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.m2e.core.ui.internal.lifecyclemapping;

import org.eclipse.m2e.core.internal.lifecyclemapping.discovery.ILifecycleMappingElementKey;
import org.eclipse.m2e.core.internal.lifecyclemapping.discovery.PackagingTypeMappingConfiguration;
import org.eclipse.m2e.core.internal.lifecyclemapping.discovery.ProjectLifecycleMappingConfiguration;
import org.eclipse.m2e.core.project.configurator.MojoExecutionKey;
import org.eclipse.osgi.util.NLS;


/**
 * PackagingTypeMappingLabelProvider
 * 
 * @author igor
 */
@SuppressWarnings("restriction")
public class PackagingTypeMappingLabelProvider implements ILifecycleMappingLabelProvider {

  private PackagingTypeMappingConfiguration element;
  private ProjectLifecycleMappingConfiguration prjconf;

  public PackagingTypeMappingLabelProvider(ProjectLifecycleMappingConfiguration prjconf, PackagingTypeMappingConfiguration element) {
    this.element = element;
    this.prjconf = prjconf;
  }

  public String getMavenText() {
    return prjconf.getRelpath();
  }

  public String getEclipseMappingText(LifecycleMappingConfiguration mappingConfiguration) {
    StringBuilder sb = new StringBuilder();
    if(element.getLifecycleMappingId() == null) {
      return "No recognized handling";
    } else if(element.getLifecycleMapping() == null) {
      return NLS.bind("Handling with id {0} not found", element.getLifecycleMappingId());
    }
    return sb.toString();
  }

  /* (non-Javadoc)
   * @see org.eclipse.m2e.core.ui.internal.lifecyclemapping.ILifecycleMappingLabelProvider#isError()
   */
  public boolean isError() {
    if(element.getLifecycleMappingId() == null) {
      return true;
    } else if(element.getLifecycleMapping() == null) {
      return true;
    } else {
      return false;
    }
  }


  /* (non-Javadoc)
   * @see org.eclipse.m2e.core.ui.internal.lifecyclemapping.ILifecycleMappingLabelProvider#getKey()
   */
  public ILifecycleMappingElementKey getKey() {
    return element.getLifecycleMappingElementKey();
  }

}