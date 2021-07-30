//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.07.19 um 12:09:30 PM CEST 
//


package org.opcfoundation.ua._2008._02.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;


/**
 * <p>Java-Klasse für ListOfCallMethodResult complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ListOfCallMethodResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CallMethodResult" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}CallMethodResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfCallMethodResult", propOrder = {
    "callMethodResult"
})
public class ListOfCallMethodResult {

    @XmlElement(name = "CallMethodResult", nillable = true)
    protected List<CallMethodResult> callMethodResult;

    /**
     * Gets the value of the callMethodResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the callMethodResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCallMethodResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CallMethodResult }
     * 
     * 
     */
    public List<CallMethodResult> getCallMethodResult() {
        if (callMethodResult == null) {
            callMethodResult = new ArrayList<CallMethodResult>();
        }
        return this.callMethodResult;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link
     * #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final ListOfCallMethodResult.Builder<_B> _other) {
        if (this.callMethodResult == null) {
            _other.callMethodResult = null;
        } else {
            _other.callMethodResult = new ArrayList<CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>>();
            for (CallMethodResult _item: this.callMethodResult) {
                _other.callMethodResult.add(((_item == null)?null:_item.newCopyBuilder(_other)));
            }
        }
    }

    public<_B >ListOfCallMethodResult.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
        return new ListOfCallMethodResult.Builder<_B>(_parentBuilder, this, true);
    }

    public ListOfCallMethodResult.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
    }

    public static ListOfCallMethodResult.Builder<Void> builder() {
        return new ListOfCallMethodResult.Builder<Void>(null, null, false);
    }

    public static<_B >ListOfCallMethodResult.Builder<_B> copyOf(final ListOfCallMethodResult _other) {
        final ListOfCallMethodResult.Builder<_B> _newBuilder = new ListOfCallMethodResult.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link
     * #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final ListOfCallMethodResult.Builder<_B> _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree callMethodResultPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("callMethodResult"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(callMethodResultPropertyTree!= null):((callMethodResultPropertyTree == null)||(!callMethodResultPropertyTree.isLeaf())))) {
            if (this.callMethodResult == null) {
                _other.callMethodResult = null;
            } else {
                _other.callMethodResult = new ArrayList<CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>>();
                for (CallMethodResult _item: this.callMethodResult) {
                    _other.callMethodResult.add(((_item == null)?null:_item.newCopyBuilder(_other, callMethodResultPropertyTree, _propertyTreeUse)));
                }
            }
        }
    }

    public<_B >ListOfCallMethodResult.Builder<_B> newCopyBuilder(final _B _parentBuilder, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return new ListOfCallMethodResult.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public ListOfCallMethodResult.Builder<Void> newCopyBuilder(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static<_B >ListOfCallMethodResult.Builder<_B> copyOf(final ListOfCallMethodResult _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final ListOfCallMethodResult.Builder<_B> _newBuilder = new ListOfCallMethodResult.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
    }

    public static ListOfCallMethodResult.Builder<Void> copyExcept(final ListOfCallMethodResult _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static ListOfCallMethodResult.Builder<Void> copyOnly(final ListOfCallMethodResult _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    public static class Builder<_B >implements Buildable
    {

        protected final _B _parentBuilder;
        protected final ListOfCallMethodResult _storedValue;
        private List<CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>> callMethodResult;

        public Builder(final _B _parentBuilder, final ListOfCallMethodResult _other, final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    if (_other.callMethodResult == null) {
                        this.callMethodResult = null;
                    } else {
                        this.callMethodResult = new ArrayList<CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>>();
                        for (CallMethodResult _item: _other.callMethodResult) {
                            this.callMethodResult.add(((_item == null)?null:_item.newCopyBuilder(this)));
                        }
                    }
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public Builder(final _B _parentBuilder, final ListOfCallMethodResult _other, final boolean _copy, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    final PropertyTree callMethodResultPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("callMethodResult"));
                    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(callMethodResultPropertyTree!= null):((callMethodResultPropertyTree == null)||(!callMethodResultPropertyTree.isLeaf())))) {
                        if (_other.callMethodResult == null) {
                            this.callMethodResult = null;
                        } else {
                            this.callMethodResult = new ArrayList<CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>>();
                            for (CallMethodResult _item: _other.callMethodResult) {
                                this.callMethodResult.add(((_item == null)?null:_item.newCopyBuilder(this, callMethodResultPropertyTree, _propertyTreeUse)));
                            }
                        }
                    }
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public _B end() {
            return this._parentBuilder;
        }

        protected<_P extends ListOfCallMethodResult >_P init(final _P _product) {
            if (this.callMethodResult!= null) {
                final List<CallMethodResult> callMethodResult = new ArrayList<CallMethodResult>(this.callMethodResult.size());
                for (CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>> _item: this.callMethodResult) {
                    callMethodResult.add(_item.build());
                }
                _product.callMethodResult = callMethodResult;
            }
            return _product;
        }

        /**
         * Fügt Werte zur Eigenschaft "callMethodResult" hinzu.
         * 
         * @param callMethodResult
         *     Werte, die zur Eigenschaft "callMethodResult" hinzugefügt werden.
         */
        public ListOfCallMethodResult.Builder<_B> addCallMethodResult(final Iterable<? extends CallMethodResult> callMethodResult) {
            if (callMethodResult!= null) {
                if (this.callMethodResult == null) {
                    this.callMethodResult = new ArrayList<CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>>();
                }
                for (CallMethodResult _item: callMethodResult) {
                    this.callMethodResult.add(new CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>(this, _item, false));
                }
            }
            return this;
        }

        /**
         * Setzt den neuen Wert der Eigenschaft "callMethodResult" (Vorher zugewiesener
         * Wert wird ersetzt)
         * 
         * @param callMethodResult
         *     Neuer Wert der Eigenschaft "callMethodResult".
         */
        public ListOfCallMethodResult.Builder<_B> withCallMethodResult(final Iterable<? extends CallMethodResult> callMethodResult) {
            if (this.callMethodResult!= null) {
                this.callMethodResult.clear();
            }
            return addCallMethodResult(callMethodResult);
        }

        /**
         * Fügt Werte zur Eigenschaft "callMethodResult" hinzu.
         * 
         * @param callMethodResult
         *     Werte, die zur Eigenschaft "callMethodResult" hinzugefügt werden.
         */
        public ListOfCallMethodResult.Builder<_B> addCallMethodResult(CallMethodResult... callMethodResult) {
            addCallMethodResult(Arrays.asList(callMethodResult));
            return this;
        }

        /**
         * Setzt den neuen Wert der Eigenschaft "callMethodResult" (Vorher zugewiesener
         * Wert wird ersetzt)
         * 
         * @param callMethodResult
         *     Neuer Wert der Eigenschaft "callMethodResult".
         */
        public ListOfCallMethodResult.Builder<_B> withCallMethodResult(CallMethodResult... callMethodResult) {
            withCallMethodResult(Arrays.asList(callMethodResult));
            return this;
        }

        /**
         * Erzeugt einen neuen "Builder" zum Zusammenbauen eines zusätzlichen Wertes für
         * die Eigenschaft "CallMethodResult".
         * Mit {@link org.opcfoundation.ua._2008._02.types.CallMethodResult.Builder#end()}
         * geht es zurück zum aktuellen Builder.
         * 
         * @return
         *     Ein neuer "Builder" zum Zusammenbauen eines zusätzlichen Wertes für die
         *     Eigenschaft "CallMethodResult".
         *     Mit {@link org.opcfoundation.ua._2008._02.types.CallMethodResult.Builder#end()}
         *     geht es zurück zum aktuellen Builder.
         */
        public CallMethodResult.Builder<? extends ListOfCallMethodResult.Builder<_B>> addCallMethodResult() {
            if (this.callMethodResult == null) {
                this.callMethodResult = new ArrayList<CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>>();
            }
            final CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>> callMethodResult_Builder = new CallMethodResult.Builder<ListOfCallMethodResult.Builder<_B>>(this, null, false);
            this.callMethodResult.add(callMethodResult_Builder);
            return callMethodResult_Builder;
        }

        @Override
        public ListOfCallMethodResult build() {
            if (_storedValue == null) {
                return this.init(new ListOfCallMethodResult());
            } else {
                return ((ListOfCallMethodResult) _storedValue);
            }
        }

        public ListOfCallMethodResult.Builder<_B> copyOf(final ListOfCallMethodResult _other) {
            _other.copyTo(this);
            return this;
        }

        public ListOfCallMethodResult.Builder<_B> copyOf(final ListOfCallMethodResult.Builder _other) {
            return copyOf(_other.build());
        }

    }

    public static class Select
        extends ListOfCallMethodResult.Selector<ListOfCallMethodResult.Select, Void>
    {


        Select() {
            super(null, null, null);
        }

        public static ListOfCallMethodResult.Select _root() {
            return new ListOfCallMethodResult.Select();
        }

    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?> , TParent >
        extends com.kscs.util.jaxb.Selector<TRoot, TParent>
    {

        private CallMethodResult.Selector<TRoot, ListOfCallMethodResult.Selector<TRoot, TParent>> callMethodResult = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.callMethodResult!= null) {
                products.put("callMethodResult", this.callMethodResult.init());
            }
            return products;
        }

        public CallMethodResult.Selector<TRoot, ListOfCallMethodResult.Selector<TRoot, TParent>> callMethodResult() {
            return ((this.callMethodResult == null)?this.callMethodResult = new CallMethodResult.Selector<TRoot, ListOfCallMethodResult.Selector<TRoot, TParent>>(this._root, this, "callMethodResult"):this.callMethodResult);
        }

    }

}
