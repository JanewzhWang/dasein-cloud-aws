/**
 * Copyright (C) 2009-2015 Dell, Inc.
 * See annotations for authorship information
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.aws.network;

import org.dasein.cloud.*;
import org.dasein.cloud.aws.AWSCloud;
import org.dasein.cloud.network.VPNCapabilities;
import org.dasein.cloud.network.VPNProtocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;

/**
 * Describes the capabilities of AWS with respect to Dasein VPN operations.
 * <p>Created by Stas Maksimov: 10/03/2014 00:48</p>
 *
 * @author Stas Maksimov
 * @version 2014.03 initial version
 * @since 2014.03
 */
public class VPCGatewayCapabilities extends AbstractCapabilities<AWSCloud> implements VPNCapabilities {
    public VPCGatewayCapabilities(AWSCloud provider) {
        super(provider);
    }

    public Requirement getVPNDataCenterConstraint() {
        return Requirement.NONE;
    }

    @Nonnull
    @Override
    public Iterable<VPNProtocol> listSupportedVPNProtocols() throws CloudException, InternalException {
        return Collections.singletonList(VPNProtocol.IPSEC1);
    }

    @Nonnull
    @Override
    public Requirement getVPNVLANConstraint() throws CloudException, InternalException {
        return null;
    }

    @Override
    public boolean supportsGateway() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean supportsVPNGateway() throws CloudException, InternalException {
        return false;
    }

    @Nullable
    @Override
    public VisibleScope getVpnVisibleScope() {
        return VisibleScope.ACCOUNT_REGION;
    }
}
