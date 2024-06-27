/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: https://www.fsf.org.
 */

package org.restcomm.protocols.ss7.tcap;

import java.util.Map;

import org.restcomm.protocols.ss7.sccp.SccpProvider;
import org.restcomm.protocols.ss7.tcap.PreviewDialogData;
import org.restcomm.protocols.ss7.tcap.PreviewDialogDataKey;
import org.restcomm.protocols.ss7.tcap.TCAPStackImpl;

/**
 *
 * @author sergey vetyutnev
 *
 */
public class TCAPStackImplWrapper extends TCAPStackImpl {

    public TCAPStackImplWrapper(SccpProvider sccpProvider, int ssn, String stackName) {
        super(stackName);

        this.tcapProvider = new TCAPProviderImplWrapper(sccpProvider, this, ssn);
    }

    public Map<PreviewDialogDataKey, PreviewDialogData> getDialogPreviewList() {
        TCAPProviderImplWrapper prov = (TCAPProviderImplWrapper) this.getProvider();
        return prov.getDialogPreviewList();
    }

}