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

package org.restcomm.protocols.ss7.map.api.service.mobility.subscriberManagement;

/**
 *
 * @author Lasith Waruna Perera
 *
 */
public enum PDNTypeValue {
    IPv4(0x01), IPv6(0x02), IPv4v6(0x03);

    private int code;

    private PDNTypeValue(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static PDNTypeValue getInstance(int code) {
        switch (code) {
            case 0x01:
                return PDNTypeValue.IPv4;
            case 0x02:
                return PDNTypeValue.IPv6;
            case 0x03:
                return PDNTypeValue.IPv4v6;
            default:
                return null;
        }
    }
}
