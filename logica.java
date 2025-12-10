
package proyectoo_ma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

// Clase utilitaria para la lógica de reducción
class CalculadoraNumerologia {

    public static int reducirADigito(int n) {
        n = Math.abs(n);
        while (n >= 10) {
            int suma = 0;
            while (n > 0) {
                suma += n % 10;
                n /= 10;
            }
            n = suma;
        }
        return n;
    }
}

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @PostMapping
    public String procesarFormulario(@RequestParam("mes_nacimiento") int mes_nacimiento,
                                     @RequestParam("dia_nacimiento") int dia_nacimiento,
                                     @RequestParam("año_nacimiento") int año_nacimiento,
                                     Model model) {

        int A = CalculadoraNumerologia.reducirADigito(mes_nacimiento);
        int B = CalculadoraNumerologia.reducirADigito(dia_nacimiento);
        int C = CalculadoraNumerologia.reducirADigito(año_nacimiento);

        int D = A + B + C;
        D = (D == 11 || D == 22 || D == 33) ? D : CalculadoraNumerologia.reducirADigito(D);

        int E = A + B;
        E = (E == 11 || E == 22 || E == 33) ? E : CalculadoraNumerologia.reducirADigito(E);

        int F = E + D;
        F = (F == 11 || F == 22 || F == 33) ? F : CalculadoraNumerologia.reducirADigito(F);

        int G = CalculadoraNumerologia.reducirADigito(C);

        int H = A + D;
        H = (H == 11 || H == 22 || H == 33) ? H : CalculadoraNumerologia.reducirADigito(H);

        int I = E + F + G;
        I = (I == 11 || I == 22 || I == 33) ? I : CalculadoraNumerologia.reducirADigito(I);

        int J = CalculadoraNumerologia.reducirADigito(D) + CalculadoraNumerologia.reducirADigito(H);
        J = (J == 11 || J == 22 || J == 33) ? J : CalculadoraNumerologia.reducirADigito(J);

        int K = A - B;
        K = (K == 11 || K == 22 || K == 33) ? K : CalculadoraNumerologia.reducirADigito(K);

        int L = C - B;
        L = (L == 11 || L == 22 || L == 33) ? L : CalculadoraNumerologia.reducirADigito(L);

        int D_reducido = CalculadoraNumerologia.reducirADigito(D);
        int M = A - D_reducido;
        M = (M == 11 || M == 22 || M == 33) ? M : CalculadoraNumerologia.reducirADigito(M);

        int N = (M == 11 || M == 22 || M == 33) ? M : CalculadoraNumerologia.reducirADigito(M);

        int O = L + K + M;
        O = (O == 11 || O == 22 || O == 33) ? O : CalculadoraNumerologia.reducirADigito(O);

        int P = CalculadoraNumerologia.reducirADigito(D) + CalculadoraNumerologia.reducirADigito(O);
        P = (P == 11 || P == 22 || P == 33) ? P : CalculadoraNumerologia.reducirADigito(P);

        int Q = K + M;
        Q = (Q == 11 || Q == 22 || Q == 33) ? Q : CalculadoraNumerologia.reducirADigito(Q);

        int R = L + M;
        R = (R == 11 || R == 22 || R == 33) ? R : CalculadoraNumerologia.reducirADigito(R);

        int S = Q + R;
        S = (S == 11 || S == 22 || S == 33) ? S : CalculadoraNumerologia.reducirADigito(S);

        // Agregar resultados al modelo
        model.addAttribute("A", A);
        model.addAttribute("B", B);
        model.addAttribute("C", C);
        model.addAttribute("D", D);
        model.addAttribute("E", E);
        model.addAttribute("F", F);
        model.addAttribute("G", G);
        model.addAttribute("H", H);
        model.addAttribute("I", I);
        model.addAttribute("J", J);
        model.addAttribute("K", K);
        model.addAttribute("L", L);
        model.addAttribute("M", M);
        model.addAttribute("N", N);
        model.addAttribute("O", O);
        model.addAttribute("P", P);
        model.addAttribute("Q", Q);
        model.addAttribute("R", R);
        model.addAttribute("S", S);

        return "resultado"; // resultado.html en carpeta templates
    }
}
