/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.Factura1;
import Controlador.producto1;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author claudio
 */
public class impresion {
    private Font fuenteTitulo = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuenteTextos = new Font(Font.FontFamily.COURIER, 6f, Font.NORMAL);
    private Font fuenteEtiquetas = new Font(Font.FontFamily.COURIER, 5f, Font.BOLD);
    private Factura1 factura;

    public impresion(Factura1 factura) {
        this.factura = factura;
    }
     private void agregarTextoNormal(Document document, String string,
            Font font, int align) {
        try {
            Chunk espacio = new Chunk(string, font);
            Paragraph p = new Paragraph(espacio);
            p.setAlignment(align);
            document.add(p);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private void agregarSeparacion(Document document) {
        try {
            Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 4, Font.NORMAL);
            Chunk espacio = new Chunk("\n", fuente);
            document.add(new Paragraph(espacio));
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private void agregarEtiqueta(PdfPTable table, String string, int align,
            boolean isBorder, int colspan) {
        // Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
        Chunk c = new Chunk(string, fuenteEtiquetas);
        PdfPCell cell = new PdfPCell(new Phrase(c));
        if (!isBorder) {
            cell.setBorder(Rectangle.NO_BORDER);
        }
        cell.setColspan(colspan);
        cell.setVerticalAlignment(align);
        cell.setHorizontalAlignment(align);
        table.addCell(cell);
    }

    private void agregarTexto(PdfPTable table, String string, int align,
            boolean isBorder, int colspan) {
        Chunk c = new Chunk(string, fuenteTextos);
        PdfPCell cell = new PdfPCell(new Phrase(c));
        if (!isBorder) {
            cell.setBorder(Rectangle.NO_BORDER);
        }
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(align);
        table.addCell(cell);
    }

    private PdfPTable crearMaestroFactura() throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        agregarEtiqueta(table, "NOMBRE:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getNombreCliente(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "APELLIDO:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getApellidoCliente(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "DIRECCIÓN:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getDireccionCliente(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "ORDEN DE COMPRA:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getOrdenCompra(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "R.U.C.:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getRut(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "Nº DE GUÍA:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getNumeroGuia(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "CONDICIÓN DE PAGO:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getCondicionPago(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "FECHA DE EMISIÓN:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getFechaEmision(), Element.ALIGN_LEFT, false, 1);
        agregarEtiqueta(table, "FECHA DE VENCIMIENTO:", Element.ALIGN_LEFT, false, 1);
        agregarTexto(table, factura.getMaestro().getFechaVencimiento(), Element.ALIGN_LEFT, false, 1);
        return table;
    }

    private PdfPTable crearDetalleFactura() throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        List<producto1> productos = factura.getProductos();
        agregarEtiqueta(table, "CANTIDAD", Element.ALIGN_CENTER, true, 1);
        agregarEtiqueta(table, "DESCRIPCIÓN", Element.ALIGN_CENTER, true, 1);
        agregarEtiqueta(table, "PREC. UNIT.", Element.ALIGN_CENTER, true, 1);
        agregarEtiqueta(table, "PREC. PARCIAL", Element.ALIGN_CENTER, true, 1);
        double parcial = 0d;
        for (producto1 producto : productos) {
            agregarTexto(table, "" + producto.getCantidad(), Element.ALIGN_CENTER, true, 1);
            agregarTexto(table, producto.getDescripcion(), Element.ALIGN_CENTER, true, 1);
            agregarTexto(table, "" + matematicas.redondear(producto.getPrecioUnitario()), Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, "" + matematicas.redondear(producto.getPrecioParcial()), Element.ALIGN_RIGHT, true, 1);
            parcial += producto.getPrecioParcial();
        }
        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
        agregarEtiqueta(table, "SUBTOTAL:", Element.ALIGN_RIGHT, true, 1);
        agregarTexto(table, "" + matematicas.redondear(parcial), Element.ALIGN_RIGHT, true, 1);
        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
        agregarEtiqueta(table, "I.G.V.:", Element.ALIGN_RIGHT, true, 1);
        agregarTexto(table, "0.18", Element.ALIGN_RIGHT, true, 1);
        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
        agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
        agregarEtiqueta(table, "TOTAL", Element.ALIGN_RIGHT, true, 1);
        agregarTexto(table, "" + parcial * 1.18, Element.ALIGN_RIGHT, true, 1);
        return table;
    }

    public void generarArchivoPDF() {
        try {
            Rectangle pagesize = new Rectangle(300f, 150f + (10f * factura.getProductos().size()));
            Document document = new Document(pagesize, 5, 5, 0, 0);
            PdfWriter.getInstance(document, new FileOutputStream(
                    "factura_orden_template.pdf"));
            document.open();
            agregarTextoNormal(document, constantes.VENDEDOR, fuenteTitulo, Element.ALIGN_CENTER);
            agregarTextoNormal(document, constantes.BLOG, fuenteTitulo, Element.ALIGN_CENTER);
            agregarSeparacion(document);
            agregarSeparacion(document);
            agregarSeparacion(document);
            document.add(crearMaestroFactura());
            agregarSeparacion(document);
            document.add(crearDetalleFactura());
            document.close();
            Runtime.getRuntime().exec("cmd.exe /c start factura_orden_template.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
