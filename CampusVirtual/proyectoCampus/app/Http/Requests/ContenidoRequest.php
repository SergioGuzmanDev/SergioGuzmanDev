<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class ContenidoRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
        //Maquina esto se pone en true para que todo el mundo
        //pueda ejecutar y usar nuestro programa
        //sino solo pueden ejecutar administradores
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'titulo' => 'required|max:40|min:5',
            'descripcion' => 'required|max:255|min:5'
        ];
    }
}
