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

package org.restcomm.protocols.ss7.map.api.service.oam;

/**
*
<code>
4, 3 - MSC Record Type
  0 - Basic
  1 - Detailed (Optional)
  2 - Spare
  3 - No MSC Trace
</code>
*
* @author sergey vetyutnev
*
*/
public enum MscRecordType {
    Basic(0), Detailed(1), Spare(2), NoMscTrace(3);

    private int code;

    private MscRecordType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static MscRecordType getInstance(int code) {
        switch (code) {
        case 0:
            return MscRecordType.Basic;
        case 1:
            return MscRecordType.Detailed;
        case 2:
            return MscRecordType.Spare;
        case 3:
            return MscRecordType.NoMscTrace;
        default:
            return null;
        }
    }

}
