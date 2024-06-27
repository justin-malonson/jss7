/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
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

package org.restcomm.protocols.ss7.tcap.api.tc.dialog.events;

import org.restcomm.protocols.ss7.sccp.parameter.SccpAddress;
import org.restcomm.protocols.ss7.tcap.asn.AbortSource;
import org.restcomm.protocols.ss7.tcap.asn.ApplicationContextName;
import org.restcomm.protocols.ss7.tcap.asn.ResultSourceDiagnostic;
import org.restcomm.protocols.ss7.tcap.asn.UserInformation;

/**
 * <pre>
 * -- NOTE � When the Abort Message is generated by the
 * Transaction sublayer, a p-Abort Cause must be
 * -- present.The u-abortCause may be generated by the
 * component sublayer in which case it is an ABRT
 * -- APDU, or by the TC-User in which case it could be
 * either an ABRT APDU or data in some user-defined
 * -- abstract syntax.
 * </pre>
 *
 * ..................
 *
 * @author amit bhayani
 * @author baranowb
 */
public interface TCUserAbortIndication extends DialogIndication {

    /**
     * Returns true if AARE Apdu is included
     *
     * @return
     */
    Boolean IsAareApdu();

    /**
     * Returns true if ABRT Apdu is included
     *
     * @return
     */
    Boolean IsAbrtApdu();

    UserInformation getUserInformation();

    AbortSource getAbortSource();

    ApplicationContextName getApplicationContextName();

    ResultSourceDiagnostic getResultSourceDiagnostic();

    SccpAddress getOriginatingAddress();

}
