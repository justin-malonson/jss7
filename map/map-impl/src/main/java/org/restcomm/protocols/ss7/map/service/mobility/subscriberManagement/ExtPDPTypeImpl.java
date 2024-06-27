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

package org.restcomm.protocols.ss7.map.service.mobility.subscriberManagement;

import javax.xml.bind.DatatypeConverter;

import javolution.xml.XMLFormat;
import javolution.xml.stream.XMLStreamException;

import org.restcomm.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtPDPType;
import org.restcomm.protocols.ss7.map.primitives.OctetStringBase;

/**
 *
 * @author sergey vetyutnev
 *
 */
public class ExtPDPTypeImpl extends OctetStringBase implements ExtPDPType {

    private static final String DATA = "data";

    private static final String DEFAULT_VALUE = null;

    public ExtPDPTypeImpl() {
        super(2, 2, "ExtPDPType");
    }

    public ExtPDPTypeImpl(byte[] data) {
        super(2, 2, "ExtPDPType", data);
    }

    public byte[] getData() {
        return data;
    }

    /**
     * XML Serialization/Deserialization
     */
    protected static final XMLFormat<ExtPDPTypeImpl> EXT_PDP_TYPE_XML = new XMLFormat<ExtPDPTypeImpl>(ExtPDPTypeImpl.class) {

        @Override
        public void read(javolution.xml.XMLFormat.InputElement xml, ExtPDPTypeImpl extPdpType) throws XMLStreamException {
            String s = xml.getAttribute(DATA, DEFAULT_VALUE);
            if (s != null) {
                extPdpType.data = DatatypeConverter.parseHexBinary(s);
            }
        }

        @Override
        public void write(ExtPDPTypeImpl extPdpType, javolution.xml.XMLFormat.OutputElement xml) throws XMLStreamException {
            if (extPdpType.data != null) {
                xml.setAttribute(DATA, DatatypeConverter.printHexBinary(extPdpType.data));
            }
        }
    };
}
