package io.github.nowakprojects.pdfitextform;

import io.github.nowakprojects.Config;

import static io.github.nowakprojects.pdfitextform.PdfElements.elements;

/*
Documentation iText:
https://developers.itextpdf.com/sites/default/files/attachments/PR%20-%20iText%20in%20Action%20-%20Second%20edition%20e-book.pdf

TODO:
Definicje pliku, np. PdfFormSchema - który może z XML odczytać dane i stworzyć PdfFormSchema
Taki PdfFormSchema musi zawierać to w jakim miejscu jest dany tag i jaka ma odległość. Może też ewentualnie mieć zmienny rozmiar czcionki, ograniczenie na wielkość pola wpisywania itp!
 */

/*
TODO: Jaka czcionka i rozmiar?
37. Nie ma w C podpis skaldajacego pola na SecondName
39. Czy wiemy cos czy mogą przyjsc 2 na raz? Czy powinno być przekleślenie? Jeśli tak, bardziej skomplikowana opcja. PdfAlternativeElement
11. Prefix ulicy?
16. Brak pola!
17. Brak miejsca na CellPhone/ MobilePhone!? Co jesli beda dwa
18. Brak FAX w XML
 */
public class PdfFormDemo {

    private static final int LEFT_PDF_SIDE = 54;

    public static void main(String[] args) throws Exception {


        PdfFormSchema pdfFormSchema = PdfFormSchema
                .withDefaultFontSize(FontSize.withValue(Config.FONT_SIZE), false)
                .addPageElements(
                        PdfPageNumber.from(1),
                        elements(
                                MultilineTextPdfElement.builder()
                                        .withTag(getASectionTag("PlaceOfSubmission"))
                                        .withMaxSize(15, 524)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE, 579),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterName.FirstName"))
                                        .withMaxSize(15, 250)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 260, 508),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterName.LastName"))
                                        .withMaxSize(15, 250)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE, 508),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.Country"))
                                        .withMaxSize(15, 105)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE, 460),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.Voivodenship"))
                                        .withMaxSize(15, 215)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 110, 460),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.County"))
                                        .withMaxSize(15, 200)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 330, 460),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.Commune"))
                                        .withMaxSize(15, 120)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE, 435),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.Street"))
                                        .withMaxSize(15, 305)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 135, 435),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.HouseNumber"))
                                        .withMaxSize(15, 55)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 405, 435),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.FlatNumber"))
                                        .withMaxSize(15, 55)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 460, 435),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.City"))
                                        .withMaxSize(15, 265)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE, 410),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("SubmitterAddress.ZipCode"))
                                        .withMaxSize(15, 70)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 272, 410),
                                SeparatedTextPdfElement.builder()
                                        .withTag(getBSectionTag("ContactData.CellPhone"))
                                        .withCharacterWidth(15)
                                        .positionedFromBottomLeft(190, 355),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("ContactData.EmailAddress"))
                                        .withMaxSize(15, 250)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 260, 338),
                                MultilineTextPdfElement.builder()
                                        .withTag(getBSectionTag("ElectronicAddress"))
                                        .withMaxSize(15, 360)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE, 238),
                                SeparatedTextPdfElement.builder()
                                        .withTag(getCSectionTag("RepresentativePersonPESEL"))
                                        .withCharacterWidth(15)
                                        .positionedFromBottomLeft(63, 785)
                                /*
                                AbsoluteTextPdfElement.builder()
                                        .withTag("imie")
                                        .positionedFromBottomLeft(330, 496),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("nazwisko")
                                        .positionedFromBottomLeft(63, 495),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("kraj")
                                        .positionedFromBottomLeft(63, 450),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("wojewodztwo")
                                        .positionedFromBottomLeft(170, 450),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("powiat")
                                        .positionedFromBottomLeft(390, 450),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("gmina")
                                        .positionedFromBottomLeft(63, 425),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("nrDomu")
                                        .positionedFromBottomLeft(460, 425),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("miejscowosc")
                                        .positionedFromBottomLeft(63, 400),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("kodPocztowy")
                                        .positionedFromBottomLeft(330, 400),
                                AbsoluteTextPdfElement.builder()
                                        .withTag("poczta")
                                        .positionedFromBottomLeft(400, 400),
                                MultilineTextPdfElement.builder()
                                        .withTag("multi")
                                        .withMaxSize(50, 100)
                                        .positionedFromBottomLeft(50, 100)*/
                        )
                ).addPageElements(
                        PdfPageNumber.from(2),
                        elements(
                                MultilineTextPdfElement.builder()
                                        .withTag(getCSectionTag("RepresentativePersonName.FirstName"))
                                        .withMaxSize(15, 250)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE, 584),
                                MultilineTextPdfElement.builder()
                                        .withTag(getCSectionTag("RepresentativePersonName.LastName"))
                                        .withMaxSize(15, 250)
                                        .positionedFromBottomLeft(LEFT_PDF_SIDE + 260, 584),
                                SeparatedTextPdfElement.builder()
                                        .withTag(getCSectionTag("RepresentativePersonPESEL"))
                                        .withCharacterWidth(15)
                                        .positionedFromBottomLeft(228, 550),
                                SeparatedTextPdfElement.builder()
                                        .withTag(getCSectionTag("RepresentativePersonNIP"))
                                        .withCharacterWidth(15)
                                        .positionedFromBottomLeft(228, 550),
                                DatePdfElement.builder()
                                        .withTag(getCSectionTag("OperationDate"))
                                        .withCharacterWidth(15)
                                        .withSpaceBetweenGroup(5)
                                        .positionedFromBottomLeft(110, 476)
                        )
                );


        final PdfFormValuesReader pdfFormValuesReader = new XmlPdfFormValuesReader();
        final PdfFormValues pdfFormValuesMax = pdfFormValuesReader.readFromFile("src/main/resources/input-test-max.xml");
        final PdfFillTool pdfFillTool = PdfFillTool.withDefinedOutputDirectory(Config.DEST_DIRECTORY);
        pdfFillTool.setIgnoreLackOfElementValue(true);

        final PdfFormValues pdfFormValuesNormal = pdfFormValuesReader.readFromFile("src/main/resources/input-test-normal.xml");


        pdfFillTool.fillPdfForm(new PdfForm(Config.ZAP_SOURCE, pdfFormSchema, pdfFormValuesMax), "filledPdf-max.pdf");
        pdfFillTool.fillPdfForm(new PdfForm(Config.ZAP_SOURCE, pdfFormSchema, pdfFormValuesNormal), "filledPdf-normal.pdf");
    }

    private static String getASectionTag(String tag) {
        return getSectionTag("A", tag);
    }

    private static String getBSectionTag(String tag) {
        return getSectionTag("B", tag);
    }

    private static String getCSectionTag(String tag) {
        return getSectionTag("C", tag);
    }

    private static String getSectionTag(String section, String tag) {
        return "Document.ACADR00001PrintData." + section + "." + tag;
    }

}
