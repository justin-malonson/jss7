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

package org.restcomm.protocols.ss7.tcapAnsi.asn;

import static org.testng.Assert.*;

import org.mobicents.protocols.asn.AsnInputStream;
import org.restcomm.protocols.ss7.tcapAnsi.asn.TCUnidentifiedMessage;
import org.testng.annotations.Test;

@Test(groups = { "asn" })
public class TcUnidentifiedTest {

    private byte[] data1 = new byte[] { -26, 15, -57, 8, 1, 1, 2, 2, 3, 3, 4, 4, -7, 3, -37, 1, 66 };

    private byte[] trIdO = new byte[] { 1, 1, 2, 2 };
    private byte[] trIdD = new byte[] { 3, 3, 4, 4 };

    @Test(groups = { "functional.decode" })
    public void testDecode() throws Exception {

        // 1
        AsnInputStream ais = new AsnInputStream(this.data1);
        int tag = ais.readTag();

        TCUnidentifiedMessage tcm = new TCUnidentifiedMessage();
        tcm.decode(ais);

        assertEquals(tcm.getOriginatingTransactionId(), trIdO);
        assertEquals(tcm.getDestinationTransactionId(), trIdD);
        assertTrue(tcm.isDialogPortionExists());

    }

}
