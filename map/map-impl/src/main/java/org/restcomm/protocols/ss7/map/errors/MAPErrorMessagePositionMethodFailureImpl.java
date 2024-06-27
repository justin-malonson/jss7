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

package org.restcomm.protocols.ss7.map.errors;

import java.io.IOException;

import javolution.xml.XMLFormat;
import javolution.xml.stream.XMLStreamException;

import org.mobicents.protocols.asn.AsnException;
import org.mobicents.protocols.asn.AsnInputStream;
import org.mobicents.protocols.asn.AsnOutputStream;
import org.mobicents.protocols.asn.Tag;
import org.restcomm.protocols.ss7.map.api.MAPException;
import org.restcomm.protocols.ss7.map.api.MAPParsingComponentException;
import org.restcomm.protocols.ss7.map.api.MAPParsingComponentExceptionReason;
import org.restcomm.protocols.ss7.map.api.errors.MAPErrorCode;
import org.restcomm.protocols.ss7.map.api.errors.MAPErrorMessagePositionMethodFailure;
import org.restcomm.protocols.ss7.map.api.errors.PositionMethodFailureDiagnostic;
import org.restcomm.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.restcomm.protocols.ss7.map.primitives.MAPExtensionContainerImpl;

/**
 *
 * @author sergey vetyutnev
 * @author amit bhayani
 */
public class MAPErrorMessagePositionMethodFailureImpl extends MAPErrorMessageImpl implements
        MAPErrorMessagePositionMethodFailure {

    private static final String POSITION_METHOD_FAILURE_DIAG = "positionMethodFailureDiagnostic";
    private static final String MAP_EXTENSION_CONTAINER = "mapExtensionContainer";

    public static final int PositionMethodFailureDiagnostic_TAG = 0;
    public static final int ExtensionContainer_TAG = 1;

    private PositionMethodFailureDiagnostic positionMethodFailureDiagnostic;
    private MAPExtensionContainer extensionContainer;

    public MAPErrorMessagePositionMethodFailureImpl(PositionMethodFailureDiagnostic positionMethodFailureDiagnostic,
            MAPExtensionContainer extensionContainer) {
        super((long) MAPErrorCode.positionMethodFailure);

        this.positionMethodFailureDiagnostic = positionMethodFailureDiagnostic;
        this.extensionContainer = extensionContainer;
    }

    public MAPErrorMessagePositionMethodFailureImpl() {
        super((long) MAPErrorCode.positionMethodFailure);
    }

    public boolean isEmPositionMethodFailure() {
        return true;
    }

    public MAPErrorMessagePositionMethodFailure getEmPositionMethodFailure() {
        return this;
    }

    public PositionMethodFailureDiagnostic getPositionMethodFailureDiagnostic() {
        return this.positionMethodFailureDiagnostic;
    }

    public MAPExtensionContainer getExtensionContainer() {
        return this.extensionContainer;
    }

    public void setPositionMethodFailureDiagnostic(PositionMethodFailureDiagnostic positionMethodFailureDiagnostic) {
        this.positionMethodFailureDiagnostic = positionMethodFailureDiagnostic;
    }

    public void setExtensionContainer(MAPExtensionContainer extensionContainer) {
        this.extensionContainer = extensionContainer;
    }

    public int getTag() throws MAPException {
        return Tag.SEQUENCE;
    }

    public int getTagClass() {
        return Tag.CLASS_UNIVERSAL;
    }

    public boolean getIsPrimitive() {
        return false;
    }

    public void decodeAll(AsnInputStream ansIS) throws MAPParsingComponentException {

        try {
            int length = ansIS.readLength();
            this._decode(ansIS, length);
        } catch (IOException e) {
            throw new MAPParsingComponentException("IOException when decoding MAPErrorMessagePositionMethodFailure: "
                    + e.getMessage(), e, MAPParsingComponentExceptionReason.MistypedParameter);
        } catch (AsnException e) {
            throw new MAPParsingComponentException("AsnException when decoding MAPErrorMessagePositionMethodFailure: "
                    + e.getMessage(), e, MAPParsingComponentExceptionReason.MistypedParameter);
        }
    }

    public void decodeData(AsnInputStream ansIS, int length) throws MAPParsingComponentException {

        try {
            this._decode(ansIS, length);
        } catch (IOException e) {
            throw new MAPParsingComponentException("IOException when decoding MAPErrorMessagePositionMethodFailure: "
                    + e.getMessage(), e, MAPParsingComponentExceptionReason.MistypedParameter);
        } catch (AsnException e) {
            throw new MAPParsingComponentException("AsnException when decoding MAPErrorMessagePositionMethodFailure: "
                    + e.getMessage(), e, MAPParsingComponentExceptionReason.MistypedParameter);
        }
    }

    private void _decode(AsnInputStream localAis, int length) throws MAPParsingComponentException, IOException, AsnException {

        this.extensionContainer = null;
        this.positionMethodFailureDiagnostic = null;

        if (localAis.getTagClass() != Tag.CLASS_UNIVERSAL || localAis.getTag() != Tag.SEQUENCE || localAis.isTagPrimitive())
            throw new MAPParsingComponentException(
                    "Error decoding MAPErrorMessagePositionMethodFailure: bad tag class or tag or parameter is primitive",
                    MAPParsingComponentExceptionReason.MistypedParameter);

        AsnInputStream ais = localAis.readSequenceStreamData(length);

        while (true) {
            if (ais.available() == 0)
                break;

            int tag = ais.readTag();

            switch (ais.getTagClass()) {
                case Tag.CLASS_CONTEXT_SPECIFIC:
                    switch (tag) {
                        case PositionMethodFailureDiagnostic_TAG:
                            int code = (int) ais.readInteger();
                            this.positionMethodFailureDiagnostic = PositionMethodFailureDiagnostic.getInstance(code);
                            break;

                        case ExtensionContainer_TAG:
                            this.extensionContainer = new MAPExtensionContainerImpl();
                            ((MAPExtensionContainerImpl) this.extensionContainer).decodeAll(ais);
                            break;

                        default:
                            ais.advanceElement();
                            break;
                    }
                    break;

                default:
                    ais.advanceElement();
                    break;
            }
        }
    }

    public void encodeAll(AsnOutputStream asnOs) throws MAPException {

        this.encodeAll(asnOs, Tag.CLASS_UNIVERSAL, Tag.SEQUENCE);
    }

    public void encodeAll(AsnOutputStream asnOs, int tagClass, int tag) throws MAPException {

        try {
            asnOs.writeTag(tagClass, false, tag);
            int pos = asnOs.StartContentDefiniteLength();
            this.encodeData(asnOs);
            asnOs.FinalizeContent(pos);
        } catch (AsnException e) {
            throw new MAPException("AsnException when encoding MAPErrorMessagePositionMethodFailure: " + e.getMessage(), e);
        }
    }

    public void encodeData(AsnOutputStream aos) throws MAPException {

        if (this.positionMethodFailureDiagnostic == null && this.extensionContainer == null)
            return;

        try {
            if (this.positionMethodFailureDiagnostic != null)
                aos.writeInteger(Tag.CLASS_CONTEXT_SPECIFIC, PositionMethodFailureDiagnostic_TAG,
                        this.positionMethodFailureDiagnostic.getCode());
            if (this.extensionContainer != null)
                ((MAPExtensionContainerImpl) this.extensionContainer).encodeAll(aos, Tag.CLASS_CONTEXT_SPECIFIC,
                        ExtensionContainer_TAG);

        } catch (IOException e) {
            throw new MAPException("IOException when encoding MAPErrorMessagePositionMethodFailure: " + e.getMessage(), e);
        } catch (AsnException e) {
            throw new MAPException("AsnException when encoding MAPErrorMessagePositionMethodFailure: " + e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("MAPErrorMessagePositionMethodFailure [");
        if (this.positionMethodFailureDiagnostic != null)
            sb.append("positionMethodFailureDiagnostic=" + this.positionMethodFailureDiagnostic.toString());
        if (this.extensionContainer != null)
            sb.append(", extensionContainer=" + this.extensionContainer.toString());
        sb.append("]");

        return sb.toString();
    }

    /**
     * XML Serialization/Deserialization
     */
    protected static final XMLFormat<MAPErrorMessagePositionMethodFailureImpl> MAP_ERROR_MESSAGE_POSITION_METHOD_FAILURE_XML = new XMLFormat<MAPErrorMessagePositionMethodFailureImpl>(
            MAPErrorMessagePositionMethodFailureImpl.class) {

        @Override
        public void read(javolution.xml.XMLFormat.InputElement xml, MAPErrorMessagePositionMethodFailureImpl errorMessage)
                throws XMLStreamException {
            MAP_ERROR_MESSAGE_XML.read(xml, errorMessage);
            String str = xml.get(POSITION_METHOD_FAILURE_DIAG, String.class);
            if (str != null)
                errorMessage.positionMethodFailureDiagnostic = Enum.valueOf(PositionMethodFailureDiagnostic.class, str);

            errorMessage.extensionContainer = xml.get(MAP_EXTENSION_CONTAINER, MAPExtensionContainerImpl.class);
        }

        @Override
        public void write(MAPErrorMessagePositionMethodFailureImpl errorMessage, javolution.xml.XMLFormat.OutputElement xml)
                throws XMLStreamException {
            MAP_ERROR_MESSAGE_XML.write(errorMessage, xml);
            if (errorMessage.getPositionMethodFailureDiagnostic() != null)
                xml.add((String) errorMessage.getPositionMethodFailureDiagnostic().toString(), POSITION_METHOD_FAILURE_DIAG,
                        String.class);

            xml.add((MAPExtensionContainerImpl) errorMessage.extensionContainer, MAP_EXTENSION_CONTAINER,
                    MAPExtensionContainerImpl.class);
        }
    };

}
